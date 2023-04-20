package com.faqcodes.tasks.adapters.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faqcodes.tasks.models.ResponseMessage;
import com.faqcodes.tasks.models.TaskInputModel;
import com.faqcodes.tasks.models.TaskOutputModel;
import com.faqcodes.tasks.usecases.UseCase;

@RestController
@RequestMapping("/api/tasks/v1")
public class CreateTaskController {

  UseCase<TaskInputModel, TaskOutputModel> createTaskUseCase;

  public CreateTaskController(UseCase<TaskInputModel, TaskOutputModel> createUserUseCase) {
    this.createTaskUseCase = createTaskUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody TaskInputModel taskInputModel) {
    var response = createTaskUseCase.execute(taskInputModel);

    if (response.getData() == null) {
      return ResponseEntity.badRequest().body(response);
    }

    return ResponseEntity.created(URI.create("")).body(response.getData());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseMessage<?>> handleException() {
    var response = new ResponseMessage<>("ERROR", "Hubo un error al obtener el recurso", null);

    return ResponseEntity.badRequest().body(response);
  }
}
