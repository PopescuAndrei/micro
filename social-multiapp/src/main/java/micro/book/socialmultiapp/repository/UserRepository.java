package micro.book.socialmultiapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import micro.book.socialmultiapp.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByAlias(final String alias);

}
