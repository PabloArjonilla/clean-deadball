package es.pmac.config;

import es.pmac.example.db.InMemoryUserRepository;
import es.pmac.example.encoder.Sha256PasswordEncoder;
import es.pmac.example.jug.JugIdGenerator;
import es.pmac.example.usecase.CreateUser;
import es.pmac.example.usecase.FindUser;
import es.pmac.example.usecase.LoginUser;
import es.pmac.example.usecase.port.IdGenerator;
import es.pmac.example.usecase.port.PasswordEncoder;
import es.pmac.example.usecase.port.UserRepository;

public class VertxConfig {

	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
	private final CreateUser createUser = new CreateUser(userRepository, passwordEncoder, idGenerator);
	private final FindUser findUser = new FindUser(userRepository);
	private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);

	public CreateUser createUser() {
		return createUser;
	}

	public FindUser findUser() {
		return findUser;
	}

	public LoginUser loginUser() {
		return loginUser;
	}
}
