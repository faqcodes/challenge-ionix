package com.faqcodes.tasks.adapters.gateways;

import java.util.Arrays;

import com.faqcodes.tasks.adapters.gateways.db.UserRepository;
import com.faqcodes.tasks.models.Role;
import com.faqcodes.tasks.models.Status;
import com.faqcodes.tasks.models.TaskModel;
import com.faqcodes.tasks.models.UserModel;

public class GetTaskGateway implements GetTask {

  private final UserRepository repository;

  public GetTaskGateway(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserModel getById(String userId, String taskId) {
    var userData = repository.getReferenceById(userId);
    if (userData == null) {
      return null;
    }

    var task = userData
        .getTasks()
        .stream()
        .filter(t -> t.getId().equals(taskId))
        .findFirst();
    if (task.isEmpty()) {
      return null;
    }

    var tasks = Arrays.asList(new TaskModel(
        task.get().getId(),
        task.get().getTitle(),
        task.get().getDescription(),
        task.get().getOverdueAt(),
        task.get().getComment(),
        Status.valueOf(task.get().getStatus())));

    return new UserModel(
        userData.getId(),
        userData.getName(),
        userData.getEmail(),
        userData.getPassword(),
        userData.getLastlogin(),
        Role.valueOf(userData.getRole()),
        tasks);
  }
}
