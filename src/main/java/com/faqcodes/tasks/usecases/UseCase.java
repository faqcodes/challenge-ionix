package com.faqcodes.tasks.usecases;

import com.faqcodes.tasks.models.Response;

public interface UseCase<T, U> {
  Response<U> execute(T model);
}
