package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.faqcodes.tasks.models.Role;

public interface CreateUser {
  Optional<User> create(
      String id,
      String name,
      String email,
      String password,
      LocalDateTime lastLogin,
      Role role,
      List<Task> tasks);
}
