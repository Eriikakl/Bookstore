package hh.sof03.bookstore;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) //JUnit5
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @Autowired
    private UserRepository urepository;

    // Testataan uuden kirjan lisäys
    @Test
    public void createNewBook() {
        Book book = new Book("Kirja", "Kirjailija", 1992, "ISBN", 12.12f, null);
        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    // Testataan kirjan etsiminen id:llä
    @Test
    public void findByBookId() {
        Book book = new Book("Kirja", "Kirjailija", 1992, "ISBN", 12.12f, null);
        brepository.save(book);
        Long bookid = book.getId();
        Optional<Book> foundedBook = brepository.findById(bookid);

        assertThat(foundedBook).isPresent();
        assertThat(foundedBook.get().getTitle()).isEqualTo("Kirja");
    }

    // Testataan kirjan poisto
    @Test
    public void deleteBook() {
        Book book = new Book("Kirja", "Kirjailija", 1992, "ISBN", 12.12f, null);
        brepository.save(book);
        Long bookid = book.getId();
        brepository.deleteById(bookid);
        Optional<Book> deletedBook = brepository.findById(bookid);

        assertThat(deletedBook).isNotPresent();
    }

     // Testataan uuden kategorian lisäys
     @Test
     public void createNewCategory() {
         Category category = new Category("horror");
         crepository.save(category);
         assertThat(category.getCategoryId()).isNotNull();
     }

      // Testataan löytää username:n perusteella
      @Test
      public void findByUsernameReturnUser() {
        User user = urepository.findByUsername("user");
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("user@email.com");
      }
}
