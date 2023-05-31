package guru.spring5webapp.spring5webapp.bootstrap;

import guru.spring5webapp.spring5webapp.domain.Author;
import guru.spring5webapp.spring5webapp.domain.Book;
import guru.spring5webapp.spring5webapp.repositories.AuthorRepository;
import guru.spring5webapp.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

// dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd= new Book("Domain Driven Design", "123455");
        eric.getBooks().add(ddd);
        ddd.getAutors().add(eric);
// salvam
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod =new Author("Rod", "Jonson");
        Book noEJB = new Book("J2EE Development without EJB", "25353534533");
        rod.getBooks().add(noEJB);
        noEJB.getAutors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books:"+bookRepository.count());
    }
}
