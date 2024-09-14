package hh.sof03.bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Tuntematon sotilas", "Väinö Linna", 2019, "9789510445785",  14.30f);
			Book book2 = new Book("Täällä Pohjantähden alla 1-3", "Väinö Linna", 2018, "9789510435724",  22.70f);
			Book book3 = new Book("Nummisuutarit", "Aleksis Kivi", 2011, "9789517461283",  7.30f);
		
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);

			log.info(book1.toString());
			log.info(book3.toString());
			
		};
	} 
}
