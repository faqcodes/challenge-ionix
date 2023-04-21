package com.faqcodes.tasks.adapters.gateways;

import com.faqcodes.tasks.models.UserModel;

public interface GetUser {
  UserModel getById(String userId) throws Exception;
}
