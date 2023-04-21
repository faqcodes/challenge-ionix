package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.faqcodes.tasks.models.Role;

public class CreateUserEntity implements CreateUser {

  @Override
  public Optional<User> create(
      String id,
      String name,
      String email,
      String password,
      LocalDateTime lastlogin,
      Role role,
      List<Task> tasks) {

    var user = new UserEntity(
        id,
        name,
        email,
        password,
        lastlogin,
        role,
        tasks);

    // if (!entity.canCreate()) {
    // }

    // if (!entity.canAssign()) {
    // }

    return Optional.of(user);
  }
}
