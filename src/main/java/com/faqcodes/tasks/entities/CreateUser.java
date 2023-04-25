package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.faqcodes.tasks.models.Result;
import com.faqcodes.tasks.models.Role;

public interface CreateUser {
  Result<User> create(
      String id,
      String name,
      String email,
      String password,
      LocalDateTime lastLogin,
      Role role,
      List<Task> tasks);
}
