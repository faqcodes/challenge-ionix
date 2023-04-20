package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.Status;

public class CreateTaskEntity implements CreateTask {

  @Override
  public Task create(String id, String title, String description, LocalDateTime overdueAt, String comment,
      Status status) {

    return new TaskEntity(id, title, description, overdueAt, comment, status);
  }

}
