package micro.book.socialmultiapp.repository;

import org.springframework.data.repository.CrudRepository;

import micro.book.socialmultiapp.domain.Multiplication;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {

}
