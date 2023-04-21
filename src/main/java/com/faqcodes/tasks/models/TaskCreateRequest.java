package com.faqcodes.tasks.models;

import java.time.LocalDateTime;

public class TaskCreateRequest {

  private final String userId;
  private final String title;
  private final String description;
  private final LocalDateTime overdueAt;

  public TaskCreateRequest(
      String userId,
      String title,
      String description,
      LocalDateTime overdueAt) {
    this.userId = userId;
    this.title = title;
    this.description = description;
    this.overdueAt = overdueAt;
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
}
