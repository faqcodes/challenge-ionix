package com.faqcodes.tasks.models;

import java.time.LocalDateTime;
import java.util.List;

public class UserInputModel {
  private final String id;
  private final String name;
  private final String email;
  private final String password;
  private final LocalDateTime lastLogin;
  private final Role role;
  private final List<TaskModel> tasks;

  public UserInputModel(String id, String name, String email, String password, LocalDateTime lastLogin, Role role,
      List<TaskModel> tasks) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.lastLogin = lastLogin;
    this.role = role;
    this.tasks = tasks;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public Role getRole() {
    return role;
  }

  public List<TaskModel> getTasks() {
    return tasks;
  }
}
