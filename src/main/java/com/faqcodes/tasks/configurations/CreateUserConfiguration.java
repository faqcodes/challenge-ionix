package com.faqcodes.tasks.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faqcodes.tasks.adapters.gateways.SaveUser;
import com.faqcodes.tasks.adapters.gateways.SaveUserGateway;
import com.faqcodes.tasks.adapters.gateways.db.UserRepository;
import com.faqcodes.tasks.adapters.presenters.CreateUserPresenter;
import com.faqcodes.tasks.adapters.presenters.Presenter;
import com.faqcodes.tasks.entities.CreateTask;
import com.faqcodes.tasks.entities.CreateTaskEntity;
import com.faqcodes.tasks.entities.CreateUser;
import com.faqcodes.tasks.entities.CreateUserEntity;
import com.faqcodes.tasks.models.UserInputModel;
import com.faqcodes.tasks.models.UserOutputModel;
import com.faqcodes.tasks.usecases.CreateUserUseCase;
import com.faqcodes.tasks.usecases.UseCase;

@Configuration
public class CreateUserConfiguration {

  @Bean
  CreateUser createUser() {
    return new CreateUserEntity();
  }

  @Bean
  CreateTask createTask() {
    return new CreateTaskEntity();
  }

  @Bean
  SaveUser saveUser(UserRepository repository) {
    return new SaveUserGateway(repository);
  }

  // @Bean
  // SecurityToken securityToken() {
  // return new JWTSecurityToken();
  // }

  @Bean
  Presenter<UserInputModel, UserOutputModel> presenter() {
    return new CreateUserPresenter();
  }

  @Bean
  UseCase<UserInputModel, UserOutputModel> createUserUseCase(
      CreateUser createUser,
      SaveUser saveUser,
      Presenter<UserInputModel, UserOutputModel> presenter) {
    return new CreateUserUseCase(createUser, saveUser, presenter);
  }

}
