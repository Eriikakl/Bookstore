package hh.sof03.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.web.BookController;
import hh.sof03.bookstore.web.BookRestController;
import hh.sof03.bookstore.web.CategoryController;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class) //JUnit4
@ExtendWith(SpringExtension.class) //JUnit5
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookcontroller;

	@Autowired
	private BookRestController bookrestcontroller;

	@Autowired
	private CategoryController categorycontroller;

	@Test
	void contextLoads() {
		assertThat(bookcontroller).isNotNull();
		assertThat(bookrestcontroller).isNotNull();
		assertThat(categorycontroller).isNotNull();
	}

}
