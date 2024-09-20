package hh.sof03.bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Book book1 = new Book("Tuntematon sotilas", "Väinö Linna", 2019, "9789510445785",  14.30f);
			Book book2 = new Book("Täällä Pohjantähden alla 1-3", "Väinö Linna", 2018, "9789510435724",  22.70f);
			Book book3 = new Book("Nummisuutarit", "Aleksis Kivi", 2011, "9789517461283",  7.30f);
		
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);

			Category category1 = new Category("classic");
			crepository.save(category1);
			Category category2 = new Category("scifi");
			crepository.save(category2);
			Category category3 = new Category("fantasy");
			crepository.save(category3);

			log.info("fetch all the categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("fetch all the books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			
		};
	} 
}
