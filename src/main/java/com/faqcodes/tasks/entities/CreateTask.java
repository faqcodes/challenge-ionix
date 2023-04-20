package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.Status;

public interface CreateTask {
  Task create(String id, String title, String description, LocalDateTime overdueAt, String comment,
  Status status);
}
