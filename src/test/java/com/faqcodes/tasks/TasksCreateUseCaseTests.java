package com.faqcodes.tasks;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.faqcodes.tasks.adapters.gateways.SaveUser;
import com.faqcodes.tasks.adapters.presenters.Presenter;
import com.faqcodes.tasks.entities.CreateTask;
import com.faqcodes.tasks.entities.Task;
import com.faqcodes.tasks.entities.TaskEntity;
import com.faqcodes.tasks.models.ErrorData;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.Result;
import com.faqcodes.tasks.models.Role;
import com.faqcodes.tasks.models.Status;
import com.faqcodes.tasks.models.TaskCreateRequest;
import com.faqcodes.tasks.models.TaskCreateResponse;
import com.faqcodes.tasks.models.UserModel;
import com.faqcodes.tasks.usecases.CreateTaskUseCase;

public class TasksCreateUseCaseTests {

  @Test
  public void testExecute_userNotFound() {
    // Arrange
    String userId = "non-existing-user-id";
    TaskCreateRequest request = new TaskCreateRequest(userId, "title", "description", LocalDateTime.now());

    CreateTask createTask = mock(CreateTask.class);
    SaveUser repository = mock(SaveUser.class);
    Presenter<TaskCreateResponse> presenter = mock(Presenter.class);

    CreateTaskUseCase useCase = new CreateTaskUseCase(createTask, repository, presenter);

    when(repository.getById(userId)).thenReturn(null);
    ErrorData expectedError = new ErrorData("ERROR", "El usuario no fue encontrado");

    // Act
    Response<TaskCreateResponse> response = useCase.execute(request);

    // Assert
    verify(presenter).error(eq("ERROR"), argThat(errors -> errors.get(0).equals(expectedError)));
  }

  @Test
  public void testExecute_createTaskFailure() {
    // Arrange
    String userId = "user-id";
    TaskCreateRequest request = new TaskCreateRequest(userId, "title", "description", LocalDateTime.now());

    CreateTask createTask = mock(CreateTask.class);
    SaveUser repository = mock(SaveUser.class);
    Presenter<TaskCreateResponse> presenter = mock(Presenter.class);

    CreateTaskUseCase useCase = new CreateTaskUseCase(createTask, repository, presenter);

    String errorMessage = "Error creating task";
    Result<Task> failureResult = new Result<>(null, new ErrorData("ERROR", errorMessage), false);
    when(createTask.create(any(), any(), any(), any(), any(), any(), any())).thenReturn(failureResult);

    // Act
    Response<TaskCreateResponse> response = useCase.execute(request);

    // Assert
    verify(presenter).error(eq("ERROR"), argThat(errors -> errors.get(0).getDescription().equals(errorMessage)));
  }

  @Test
  public void testExecute_saveUserFailure() {
    // Arrange
    String userId = "user-id";
    TaskCreateRequest request = new TaskCreateRequest(userId, "title", "description", LocalDateTime.now());

    CreateTask createTask = mock(CreateTask.class);
    SaveUser repository = mock(SaveUser.class);
    Presenter<TaskCreateResponse> presenter = mock(Presenter.class);

    CreateTaskUseCase useCase = new CreateTaskUseCase(createTask, repository, presenter);

    try {
      when(repository.save(any())).thenThrow(new RuntimeException("Error saving user"));

      // Act
      Response<TaskCreateResponse> response = useCase.execute(request);

      // Assert
      verify(presenter).error(eq("Error saving user"), eq(null));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testExecute_success() {
    // Arrange
    String userId = "user-id";
    TaskCreateRequest request = new TaskCreateRequest(userId, "title", "description", LocalDateTime.now());

    CreateTask createTask = mock(CreateTask.class);
    SaveUser repository = mock(SaveUser.class);
    Presenter<TaskCreateResponse> presenter = mock(Presenter.class);

    CreateTaskUseCase useCase = new CreateTaskUseCase(createTask, repository, presenter);

    Task taskEntity = new TaskEntity(
        UUID.randomUUID().toString(),
        userId,
        "title",
        "description",
        LocalDateTime.now(),
        null,
        Status.ASIGNADA);
    Result<Task> successResult = new Result<>(taskEntity, null, true);
    when(createTask.create(any(), any(), any(), any(), any(), any(), any())).thenReturn(successResult);

    UserModel user = new UserModel(userId, "user name", "user@example.com", "password", null, Role.EJECUTOR, null);
    when(repository.getById(userId)).thenReturn(user);

    // Act
    Response<TaskCreateResponse> response = useCase.execute(request);

    // Assert
    verify(presenter).success(eq("La tarea se ha creado satisfactoriamente"),
        argThat(output -> output.getId().equals(taskEntity.getId()) &&
            output.getTitle().equals(taskEntity.getTitle()) &&
            output.getDescription().equals(taskEntity.getDescription()) &&
            output.getOverdueAt().equals(taskEntity.getOverdueAt()) &&
            output.getStatus().equals(taskEntity.getStatus())));
  }

}
