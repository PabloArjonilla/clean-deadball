package es.pmac.config;

import es.pmac.example.db.InMemoryUserRepository;
import es.pmac.example.usecase.port.IdGenerator;
import es.pmac.example.usecase.port.PasswordEncoder;
import es.pmac.example.usecase.port.UserRepository;
import es.pmac.example.encoder.Sha256PasswordEncoder;
import es.pmac.example.jug.JugIdGenerator;
import es.pmac.example.usecase.CreateUser;
import es.pmac.example.usecase.FindUser;
import es.pmac.example.usecase.LoginUser;

public class ManualConfig {
	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
