package com.faqcodes.tasks.adapters.presenters;

import java.util.List;

import com.faqcodes.tasks.models.ErrorList;
import com.faqcodes.tasks.models.Response;

public interface Presenter<T> {
  Response<T> success(String message, T model);
  Response<T> error(String message, List<ErrorList> errors);
}
