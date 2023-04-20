package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.Status;

public interface Task {

  public String getId();

  public String getTitle();

  public String getDescription();

  public LocalDateTime getOverdueAt();

  public String getComment();

  public Status getStatus();
}
