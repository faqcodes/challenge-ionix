package com.faqcodes.tasks.usecases;

import java.util.Arrays;
import java.util.UUID;

import com.faqcodes.tasks.adapters.gateways.SaveUser;
import com.faqcodes.tasks.adapters.presenters.Presenter;
import com.faqcodes.tasks.entities.CreateUser;
import com.faqcodes.tasks.models.Response;
import com.faqcodes.tasks.models.UserInputModel;
import com.faqcodes.tasks.models.UserModel;
import com.faqcodes.tasks.models.UserOutputModel;

public class CreateUserUseCase implements UseCase<UserInputModel, UserOutputModel> {

  private final CreateUser createUser;
  private final SaveUser repository;
  private final Presenter<UserOutputModel> presenter;

  public CreateUserUseCase(
      CreateUser createUser,
      SaveUser repository,
      Presenter<UserOutputModel> presenter) {
    this.createUser = createUser;
    this.repository = repository;
    this.presenter = presenter;
  }

  @Override
  public Response<UserOutputModel> execute(UserInputModel inputModel) {
    // Get ID
    final var id = UUID.randomUUID().toString();

    // Create User Entity
    var result = createUser.create(
        id,
        inputModel.getName(),
        inputModel.getEmail(),
        inputModel.getPassword(),
        null,
        inputModel.getRole(),
        null);

    if (!result.isSuccess()) {
      return presenter.error("BUSINESS ERROR", Arrays.asList(result.getError()));
    }

    final var user = result.getEntity();

    // -----------------------------------------------
    // Validate User Application Rules
    // -----------------------------------------------

    // -----------------------------------------------

    // Create User Data
    final var userData = new UserModel(
        id,
        user.getName(),
        user.getEmail(),
        user.getPassword(),
        null,
        user.getRole(),
        null);

    try {
      // Save User
      repository.save(userData);
    } catch (Exception e) {
      // Return error information
      return presenter.error(e.getMessage(), null);
    }

    // Create output Data
    final var outputModel = new UserOutputModel(
        id,
        user.getName(),
        user.getEmail(),
        user.getRole());

    // Return success information
    return presenter.success("El usuario se ha creado satisfactoriamente", outputModel);
  }
}
