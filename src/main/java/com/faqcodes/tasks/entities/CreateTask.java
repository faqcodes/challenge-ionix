package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.Optional;

import com.faqcodes.tasks.models.Status;

public interface CreateTask {
  Optional<Task> create(
      String id,
      String userId,
      String title,
      String description,
      LocalDateTime overdueAt,
      String comment,
      Status status);
}
