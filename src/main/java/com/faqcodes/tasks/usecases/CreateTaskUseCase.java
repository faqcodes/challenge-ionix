package com.faqcodes.tasks.usecases;

import java.util.Arrays;
import java.util.UUID;

import com.faqcodes.tasks.adapters.gateways.SaveUser;
import com.faqcodes.tasks.adapters.presenters.Presenter;
import com.faqcodes.tasks.entities.CreateTask;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.TaskCreateRequest;
import com.faqcodes.tasks.models.TaskCreateResponse;
import com.faqcodes.tasks.models.TaskModel;
import com.faqcodes.tasks.models.UserModel;

public class CreateTaskUseCase implements UseCase<TaskCreateRequest, TaskCreateResponse> {

  private final CreateTask createTask;
  private final SaveUser repository;
  private final Presenter<TaskCreateResponse> presenter;

  public CreateTaskUseCase(
      CreateTask createTask,
      SaveUser repository,
      Presenter<TaskCreateResponse> presenter) {
    this.createTask = createTask;
    this.repository = repository;
    this.presenter = presenter;
  }

  @Override
  public Response<TaskCreateResponse> execute(TaskCreateRequest taskCreateRequest) {
    // Get TaskID
    final var taskId = UUID.randomUUID().toString();
    // Get related User
    final var user = repository.getById(taskCreateRequest.getUserId());
    if (user == null) {
      // TODO: Validate
      return null;
    }
    // Create Task Entity
    final var task = createTask.create(
        taskId,
        taskCreateRequest.getUserId(),
        taskCreateRequest.getTitle(),
        taskCreateRequest.getDescription(),
        taskCreateRequest.getOverdueAt(),
        null,
        null);

    if (task.isEmpty()) {
      // TODO: Validate
      return null;
    }
    // -----------------------------------------------
    // Validate User Entity Business Rules
    // -----------------------------------------------

    // -----------------------------------------------
    // Validate User Application Rules
    // -----------------------------------------------

    // Create User Data
    final var userData = new UserModel(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPassword(),
        null,
        user.getRole(),
        Arrays.asList(
            new TaskModel(
                task.get().getId(),
                task.get().getTitle(),
                task.get().getDescription(),
                task.get().getOverdueAt(),
                task.get().getComment(),
                task.get().getStatus())));

    try {
      // Save User
      repository.save(userData);
    } catch (Exception e) {
      // Return error information
      return presenter.error(e.getMessage(), null);
    }

    // Create output Data
    final var outputModel = new TaskCreateResponse(
        task.get().getId(),
        task.get().getTitle(),
        task.get().getDescription(),
        task.get().getOverdueAt(),
        task.get().getComment(),
        task.get().getStatus());

    // Return success information
    return presenter.success("La tarea se ha creado satisfactoriamente", outputModel);
  }

}
