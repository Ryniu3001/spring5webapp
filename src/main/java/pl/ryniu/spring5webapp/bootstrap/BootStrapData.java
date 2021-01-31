package pl.ryniu.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.ryniu.spring5webapp.domain.Author;
import pl.ryniu.spring5webapp.domain.Book;
import pl.ryniu.spring5webapp.domain.Publisher;
import pl.ryniu.spring5webapp.repositories.AuthorRepository;
import pl.ryniu.spring5webapp.repositories.BookRepository;
import pl.ryniu.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
		
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
			
		Publisher pub1 = new Publisher();
		pub1.setAddressLine1("addresss 1");
		pub1.setCity("Poznań");
		pub1.setName("Spring publisher");
		pub1.setZip("61-131");
		publisherRepository.save(pub1);
		
		System.out.println("Publishers count: " + publisherRepository.count());
		publisherRepository.findAll().forEach(System.out::println);
		
		Author eric = new Author("Eric", "Evans");
		Book springBook = new Book("Spring", "123");
		
		springBook.getAuthors().add(eric);
		eric.getBooks().add(springBook);
		springBook.setPublisher(pub1);
		pub1.getBooks().add(springBook);
		authorRepository.save(eric);
		bookRepository.save(springBook);
		publisherRepository.save(pub1);
		
		Author rod = new Author("Rod", "Johnson");
		Book book2 = new Book("Book2", "2222");
		rod.getBooks().add(book2);
		book2.getAuthors().add(rod);
		book2.setPublisher(pub1);
		pub1.getBooks().add(book2);
		authorRepository.save(rod);
		bookRepository.save(book2);
		publisherRepository.save(pub1);
		
		System.out.println("Books count: " + bookRepository.count());
		authorRepository.findAll().forEach(System.out::println);

		
	}

}
