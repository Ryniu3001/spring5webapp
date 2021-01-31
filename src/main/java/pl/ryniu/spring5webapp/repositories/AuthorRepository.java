package pl.ryniu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.ryniu.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
