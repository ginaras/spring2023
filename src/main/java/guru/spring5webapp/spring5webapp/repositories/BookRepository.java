package guru.spring5webapp.spring5webapp.repositories;

import guru.spring5webapp.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
