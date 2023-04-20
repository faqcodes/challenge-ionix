package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.faqcodes.tasks.models.Role;

public class CreateUserEntity implements CreateUser {

  @Override
  public User create(String id, String name, String email, String password, LocalDateTime lastLogin, Role role,
  List<Task> tasks) {

    final var lastlogin = LocalDateTime.now();

    return new UserEntity(id,  name,  email, password,  lastLogin,  role, tasks);
  }

}
