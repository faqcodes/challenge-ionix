package com.faqcodes.tasks.models;

public class Result<T> {
  T entity;
  ErrorData error;
  boolean isSuccess;

  public Result(T entity, ErrorData error, boolean isSuccess) {
    this.entity = entity;
    this.error = error;
    this.isSuccess = isSuccess;
  }

  public T getEntity() {
    return entity;
  }

  public ErrorData getError() {
    return error;
  }

  public boolean isSuccess() {
    return isSuccess;
  }
}
