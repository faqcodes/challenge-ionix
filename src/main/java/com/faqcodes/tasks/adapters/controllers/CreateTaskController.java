package com.faqcodes.tasks.adapters.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faqcodes.tasks.models.Code;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.TaskCreateRequest;
import com.faqcodes.tasks.models.TaskCreateResponse;
import com.faqcodes.tasks.usecases.UseCase;

@RestController
@RequestMapping("/api/tasks/v1")
public class CreateTaskController extends BaseController {

  UseCase<TaskCreateRequest, TaskCreateResponse> createTaskUseCase;

  public CreateTaskController(UseCase<TaskCreateRequest, TaskCreateResponse> createTaskUseCase) {
    this.createTaskUseCase = createTaskUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity<Response<TaskCreateResponse>> create(@RequestBody TaskCreateRequest taskCreateRequest) {
    var response = createTaskUseCase.execute(taskCreateRequest);

    if (response.getCode() == Code.ERROR) {
      return ResponseEntity
          .badRequest()
          .body(response);
    }

    return ResponseEntity
        .created(URI.create(""))
        .body(response);
  }
}
