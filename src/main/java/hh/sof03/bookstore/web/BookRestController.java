package hh.sof03.bookstore.web;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookrepository; 

    // haetaan kaikki kirjat 
    // http://localhost:8080/api/books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBookRest() {
        
        List<Book> books = (List<Book>) bookrepository.findAll();
        return books;
    }
    
    // haetaan kirja id:n perusteella
    // http://localhost:8080/api/books/{id}
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name="id") Long bookId) {
        return bookrepository.findById(bookId);
    }

    // tallennetaan lisätty kirja
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public @ResponseBody Book saveNewBookRest(@RequestBody Book newBook) {
        return bookrepository.save(newBook);
    }

}
