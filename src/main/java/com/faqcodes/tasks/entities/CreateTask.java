package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.Result;
import com.faqcodes.tasks.models.Status;

public interface CreateTask {
  Result<Task> create(
      String id,
      String userId,
      String title,
      String description,
      LocalDateTime overdueAt,
      String comment,
      Status status);
}
