package com.faqcodes.tasks.adapters.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faqcodes.tasks.models.UserInputModel;
import com.faqcodes.tasks.models.UserOutputModel;
import com.faqcodes.tasks.usecases.UseCase;

@RestController
@RequestMapping("/api/users/v1")
public class CreateUserController extends BaseController {

  UseCase<UserInputModel, UserOutputModel> createUserUseCase;

  public CreateUserController(UseCase<UserInputModel, UserOutputModel> createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody UserInputModel userInputModel) {
    var response = createUserUseCase.execute(userInputModel);

    if (response.getData() == null) {
      return ResponseEntity.badRequest().body(response);
    }

    return ResponseEntity.created(URI.create("")).body(response.getData());
  }
}
