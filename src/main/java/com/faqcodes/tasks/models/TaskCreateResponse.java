package com.faqcodes.tasks.models;

import java.time.LocalDateTime;

public class TaskCreateResponse {

  private final String id;
  private final String title;
  private final String description;
  private final LocalDateTime overdueAt;
  private final String comment;
  private final Status status;

  public TaskCreateResponse(
      String id,
      String title,
      String description,
      LocalDateTime overdueAt,
      String comment,
      Status status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.overdueAt = overdueAt;
    this.comment = comment;
    this.status = status;
  }
}
