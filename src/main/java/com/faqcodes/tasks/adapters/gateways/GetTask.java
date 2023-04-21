package com.faqcodes.tasks.adapters.gateways;

import com.faqcodes.tasks.models.UserModel;

public interface GetTask {
  UserModel getById(String userId, String taskId);
}
