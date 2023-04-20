package com.faqcodes.tasks.adapters.presenters;

import com.faqcodes.tasks.models.ResponseMessage;

public interface Presenter<T, U> {
  ResponseMessage<U> successResponse(String message, U outputModel);
  ResponseMessage<U> errorResponse(String message, T inputModel);
}
