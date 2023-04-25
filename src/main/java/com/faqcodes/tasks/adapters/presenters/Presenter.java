package com.faqcodes.tasks.adapters.presenters;

import java.util.List;

import com.faqcodes.tasks.models.ErrorData;
import com.faqcodes.tasks.models.Response;

public interface Presenter<T> {
  Response<T> success(String message, T model);
  Response<T> error(String message, List<ErrorData> errors);
}
