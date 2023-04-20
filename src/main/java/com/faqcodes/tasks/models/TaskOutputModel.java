package com.faqcodes.tasks.models;

import java.time.LocalDateTime;

public class TaskOutputModel {
  
  private final String id;
  private final String title;
  private final String description;
  private final LocalDateTime overdueAt;
  private final String comment;
  private final Status status;

  public TaskOutputModel(String id, String title, String description, LocalDateTime overdueAt, String comment,
      Status status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.overdueAt = overdueAt;
    this.comment = comment;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getOverdueAt() {
    return overdueAt;
  }

  public String getComment() {
    return comment;
  }

  public Status getStatus() {
    return status;
  }
}
