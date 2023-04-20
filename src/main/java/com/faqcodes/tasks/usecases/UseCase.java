package com.faqcodes.tasks.usecases;

import com.faqcodes.tasks.models.ResponseMessage;

public interface UseCase<T, U> {
  ResponseMessage<U> execute(T inputModel);
}
