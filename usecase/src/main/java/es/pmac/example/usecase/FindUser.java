package es.pmac.example.usecase;

import es.pmac.example.domain.entity.User;
import es.pmac.example.usecase.port.UserRepository;
import java.util.List;
import java.util.Optional;

public final class FindUser {

	private final UserRepository repository;

	public FindUser(final UserRepository repository) {
		this.repository = repository;
	}

	public Optional<User> findById(final String id) {
		return repository.findById(id);
	}

	public List<User> findAllUsers() {
		return repository.findAllUsers();
	}
}
