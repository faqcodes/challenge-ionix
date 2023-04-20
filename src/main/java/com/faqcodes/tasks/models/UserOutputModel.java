package com.faqcodes.tasks.models;

import java.time.LocalDateTime;
import java.util.List;

public class UserOutputModel {
  private final String id;
  private final String name;
  private final String email;
  private final Role role;

  public UserOutputModel(String id, String name, String email, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.role = role;
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

  public Role getRole() {
    return role;
  }
}
