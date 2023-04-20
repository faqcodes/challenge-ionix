package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.faqcodes.tasks.models.Role;

public interface User {
  public String getId();

  public String getName();

  public String getEmail();

  public String getPassword();

  public LocalDateTime getLastLogin();

  public Role getRole();

  public List<Task> getTasks();

}
