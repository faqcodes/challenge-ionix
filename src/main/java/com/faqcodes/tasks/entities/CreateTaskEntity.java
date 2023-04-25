package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;

import com.faqcodes.tasks.models.ErrorData;
import com.faqcodes.tasks.models.Result;
import com.faqcodes.tasks.models.Status;

public class CreateTaskEntity implements CreateTask {

  @Override
  public Result<Task> create(
      String id,
      String userId,
      String title,
      String description,
      LocalDateTime overdueAt,
      String comment,
      Status status) {

    final var task = new TaskEntity(
        id,
        userId,
        title,
        description,
        overdueAt,
        comment,
        status);

    // -----------------------------------------------
    // Validate User Entity Business Rules
    // -----------------------------------------------

    if (!task.canUpdate()) {
      var error = new ErrorData(
          "BUSINESS ERROR",
          "Solo puede asignar si el estado es ASIGNADA");

      return new Result<>(
          null,
          error,
          false);
    }

    return new Result<>(
        task,
        null,
        true);
  }

}
