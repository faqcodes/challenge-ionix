package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.Status;

public class TaskEntity implements Task {

  private final String id;
  private final String userId;
  private final String title;
  private final String description;
  private final LocalDateTime overdueAt;
  private final String comment;
  private final Status status;

  public TaskEntity(
      String id,
      String userId,
      String title,
      String description,
      LocalDateTime overdueAt,
      String comment,
      Status status) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.description = description;
    this.overdueAt = overdueAt;
    this.comment = comment;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public String getUserId() {
    return userId;
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

  public boolean isOverdue() {
    return LocalDateTime.now().compareTo(this.overdueAt) > 0;
  }

  public boolean canUpdate() {
    return this.status == Status.ASIGNADA;
  }
}
