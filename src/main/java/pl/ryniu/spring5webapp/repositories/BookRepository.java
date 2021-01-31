package pl.ryniu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.ryniu.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
