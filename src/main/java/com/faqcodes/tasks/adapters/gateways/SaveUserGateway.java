package com.faqcodes.tasks.adapters.gateways;

import java.util.ArrayList;
import java.util.Arrays;

import com.faqcodes.tasks.adapters.gateways.db.TaskData;
import com.faqcodes.tasks.adapters.gateways.db.UserData;
import com.faqcodes.tasks.adapters.gateways.db.UserRepository;
import com.faqcodes.tasks.models.Role;
import com.faqcodes.tasks.models.Status;
import com.faqcodes.tasks.models.TaskModel;
import com.faqcodes.tasks.models.UserModel;

public class SaveUserGateway implements SaveUser {

  private final UserRepository repository;

  public SaveUserGateway(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public boolean save(UserModel model) throws Exception {

    final var taskData = new ArrayList<TaskData>();

    model.getTasks().forEach(
        task -> taskData.add(
            new TaskData(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getComment(),
                task.getOverdueAt(),
                task.getStatus())));

    var userData = new UserData(
        model.getId(),
        model.getName(),
        model.getEmail(),
        model.getPassword(),
        model.getLastLogin(),
        model.getRole(),
        taskData);

    var user = repository.save(userData);

    return user != null;
  }

  @Override
  public UserModel getById(String userId) {
    var userData = repository.getReferenceById(userId);

    return new UserModel(
        userData.getId(),
        userData.getName(),
        userData.getEmail(),
        userData.getPassword(),
        userData.getLastlogin(),
        Role.valueOf(userData.getRole()),
        null);
  }
}
