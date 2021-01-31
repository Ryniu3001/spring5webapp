package pl.ryniu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.ryniu.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
