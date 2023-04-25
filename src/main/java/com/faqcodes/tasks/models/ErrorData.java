package com.faqcodes.tasks.models;

public class ErrorData {
  private final String code;
  private final String description;

  public ErrorData(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}