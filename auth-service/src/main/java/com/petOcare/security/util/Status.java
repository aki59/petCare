package com.petOcare.security.util;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class Status {
  private String message;
  private String error;

  public Status(final String message) {
    super();
    this.message = message;
  }

  public Status(final String message, final String error) {
    super();
    this.message = message;
    this.error = error;
  }

  public Status(final List<ObjectError> allErrors, final String error) {
    this.error = error;
    final String temp = allErrors.stream().map(e -> {
      if (e instanceof FieldError) {
        return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\""
            + e.getDefaultMessage() + "\"}";
      } else {
        return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\""
            + e.getDefaultMessage() + "\"}";
      }
    }).collect(Collectors.joining(","));
    this.message = "[" + temp + "]";
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public String getError() {
    return error;
  }

  public void setError(final String error) {
    this.error = error;
  }

}
