package es.pmac.example.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.pmac.config.SpringConfig;
import es.pmac.example.controller.UserController;
import es.pmac.example.usecase.CreateUser;
import es.pmac.example.usecase.FindUser;
import es.pmac.example.usecase.LoginUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	private final SpringConfig config = new SpringConfig();

	@Bean
	public ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}

	@Bean
	public CreateUser createUser() {
		return config.createUser();
	}

	@Bean
	public FindUser findUser() {
		return config.findUser();
	}

	@Bean
	public LoginUser loginUser() {
		return config.loginUser();
	}

	@Bean
	public UserController userController() {
		return new UserController(createUser(), findUser(), loginUser());
	}
}
