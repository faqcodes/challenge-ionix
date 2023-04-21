package com.faqcodes.tasks.adapters.presenters;

import java.util.List;

import com.faqcodes.tasks.models.Code;
import com.faqcodes.tasks.models.ErrorList;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.TaskCreateResponse;

public class CreateTaskPresenter implements Presenter<TaskCreateResponse> {

  @Override
  public Response<TaskCreateResponse> success(String message, TaskCreateResponse model) {
    return new Response<>(Code.SUCCESS, message, null, model);
  }

  @Override
  public Response<TaskCreateResponse> error(String message, List<ErrorList> errors) {
    return new Response<>(Code.ERROR, message, errors, null);
  }
  
}
