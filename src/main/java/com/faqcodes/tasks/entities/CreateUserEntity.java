package com.faqcodes.tasks.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.faqcodes.tasks.models.ErrorData;
import com.faqcodes.tasks.models.Result;
import com.faqcodes.tasks.models.Role;

public class CreateUserEntity implements CreateUser {

  @Override
  public Result<User> create(
      String id,
      String name,
      String email,
      String password,
      LocalDateTime lastlogin,
      Role role,
      List<Task> tasks) {

    var user = new UserEntity(
        id,
        name,
        email,
        password,
        lastlogin,
        role,
        tasks);

    // -----------------------------------------------
    // Validate User Entity Business Rules
    // -----------------------------------------------

    if (!user.canCreate()) {
      var error = new ErrorData(
          "BUSINESS ERROR",
          "Un usuario con ROl Administrador solo puede crear usuarios con Rol EJECUTOR o AUDITOR");

      return new Result<>(
          null,
          error,
          false);
    }

    if (!user.canAssign()) {
      var error = new ErrorData(
          "BUSINESS ERROR",
          "Solo se puede asignar una tarea a usuarios con Rol EJECUTOR");

      return new Result<>(
          null,
          error,
          false);
    }

    return new Result<>(
        user,
        null,
        true);
  }
}
