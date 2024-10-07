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
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookrepository, CategoryRepository categoryrepository, UserRepository userrepository) {
		return (args) -> {
			Category category1 = new Category("classic");
			categoryrepository.save(category1);
			Category category2 = new Category("scifi");
			categoryrepository.save(category2);
			Category category3 = new Category("fantasy");
			categoryrepository.save(category3);

			Book book1 = new Book("Tuntematon sotilas", "Väinö Linna", 2019, "9789510445785",  14.30f, category1);
			Book book2 = new Book("Täällä Pohjantähden alla 1-3", "Väinö Linna", 2018, "9789510435724",  22.70f, category1);
			Book book3 = new Book("The lord of the rings", "J.R.R. Tolkien", 2005, "9780618640157",  37.00f, category3);
			Book book4 = new Book("The hitchhiker's guide to the galaxy", "Douglas Adams", 1995, "9780345391803",  12.80f, category2);
			bookrepository.save(book1);
			bookrepository.save(book2);
			bookrepository.save(book3);
			bookrepository.save(book4);

			

			log.info("fetch all the categories");
			for (Category category : categoryrepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("fetch all the books");
			for (Book book : bookrepository.findAll()) {
				log.info(book.toString());
			}

			// Luodaan käyttäjät admin/admin user/user
			User user1 = new User("user", "$2a$10$E9y1M0Q9fA7GgIPWagsE1OBQoTvRqZghAYHqEk5MzGSFSqY9PESLS", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$WIBG7bOutK2thvKX6vRfUeqctr4bTF7nL221IWdaWSPbWbNoHGNd.", "admin@email.com", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			
		};
	} 
}
