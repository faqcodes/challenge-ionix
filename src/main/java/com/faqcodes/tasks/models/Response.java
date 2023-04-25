package com.faqcodes.tasks.models;

import java.util.List;

public class Response<T> {
  private final Code code;
  private final String message;
  private final List<ErrorData> errors;
  private final T data;

  public Code getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  public Response(Code code, String message, List<ErrorData> errors, T data) {
    this.code = code;
    this.message = message;
    this.errors = errors;
    this.data = data;
  }
}
