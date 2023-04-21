package com.faqcodes.tasks.adapters.presenters;

import java.util.List;

import com.faqcodes.tasks.models.Code;
import com.faqcodes.tasks.models.ErrorList;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.UserOutputModel;

public class CreateUserPresenter implements Presenter<UserOutputModel> {

  @Override
  public Response<UserOutputModel> success(String message, UserOutputModel userOutputModel) {
    return new Response<>(Code.SUCCESS, message, null, userOutputModel);
  }

  @Override
  public Response<UserOutputModel> error(String message, List<ErrorList> errors) {
    return new Response<>(Code.ERROR, message, errors, null);
  }
  
}
