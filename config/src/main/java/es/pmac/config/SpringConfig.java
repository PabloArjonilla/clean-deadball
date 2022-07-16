package es.pmac.config;

import es.pmac.example.db.hazelcast.HazelcastUserRepository;
import es.pmac.example.usecase.port.PasswordEncoder;
import es.pmac.example.usecase.port.UserRepository;
import es.pmac.example.encoder.Sha256PasswordEncoder;
import es.pmac.example.usecase.CreateUser;
import es.pmac.example.usecase.FindUser;
import es.pmac.example.usecase.LoginUser;
import es.pmac.example.uuid.UuidGenerator;

public class SpringConfig {

	private final UserRepository userRepository = new HazelcastUserRepository();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, new UuidGenerator());
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
