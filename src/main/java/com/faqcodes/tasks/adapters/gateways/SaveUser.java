package com.faqcodes.tasks.adapters.gateways;

import com.faqcodes.tasks.models.UserModel;

public interface SaveUser {
  UserModel getById(String userId);
  boolean save(UserModel model) throws Exception;  
}
