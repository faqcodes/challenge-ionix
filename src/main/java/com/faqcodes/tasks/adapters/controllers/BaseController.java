package com.faqcodes.tasks.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.faqcodes.tasks.models.Code;
import com.faqcodes.tasks.models.Response;

public class BaseController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Response<?>> handleException() {
    var response = new Response<>(
        Code.ERROR,
        "Hubo un error al obtener el recurso",
        null,
        null);

    return ResponseEntity.badRequest().body(response);
  }

}
