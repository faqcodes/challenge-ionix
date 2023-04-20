package com.faqcodes.tasks.adapters.gateways;

import com.faqcodes.tasks.models.UserModel;

public interface SaveUser {
  boolean save(UserModel model) throws Exception;
}
