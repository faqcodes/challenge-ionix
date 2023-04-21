package com.faqcodes.tasks.adapters.gateways;

import com.faqcodes.tasks.adapters.gateways.db.UserRepository;
import com.faqcodes.tasks.models.Role;
import com.faqcodes.tasks.models.UserModel;

public class GetUserGateway implements GetUser {

  private final UserRepository repository;

  public GetUserGateway(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserModel getById(String userId) throws Exception {
    var userData = repository.getReferenceById(userId);

    return new UserModel(
        userData.getId(),
        userData.getName(),
        userData.getEmail(),
        userData.getPassword(),
        userData.getLastlogin(),
        Role.valueOf(userData.getRole()),
        null);
  }
}
