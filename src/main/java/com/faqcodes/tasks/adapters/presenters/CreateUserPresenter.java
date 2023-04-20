package com.faqcodes.tasks.adapters.presenters;

import com.faqcodes.tasks.models.ResponseMessage;
import com.faqcodes.tasks.models.UserInputModel;
import com.faqcodes.tasks.models.UserOutputModel;

public class CreateUserPresenter implements Presenter<UserInputModel, UserOutputModel> {

  @Override
  public ResponseMessage<UserOutputModel> successResponse(String message, UserOutputModel outputModel) {
    return new ResponseMessage<>("SUCCESS", message, outputModel);
  }

  @Override
  public ResponseMessage<UserOutputModel> errorResponse(String message, UserInputModel inputModel) {
    return new ResponseMessage<>("ERROR", message, null);
  }
  
}
