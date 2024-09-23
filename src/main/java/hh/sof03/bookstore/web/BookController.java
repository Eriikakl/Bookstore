package hh.sof03.bookstore.web;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;




@Controller
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository crepository;

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String showBookstore() {
        return "index";
    }
    // Kirjojen listaus
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
        
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }  
    // Kirjojen lisäys
    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());

        List<Category> categories = new ArrayList<>();
        for (Category category : crepository.findAll()) {
            categories.add(category);
        }
        model.addAttribute("categories", categories);

        return "addbook";
    }
    // Kirjojen muokkaaminen
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId).orElse(null);
        model.addAttribute("book", book); // book tilalle repository.findById(bookId)

        List<Category> categories = new ArrayList<>();
        for (Category category : crepository.findAll()) {
            categories.add(category);
        }
        model.addAttribute("categories", categories);

        return "editbook";
    }
    // Kirjojen lisäyksen tai muokkauksen tallennus 
    // Tee oma save-metodi muokkaukselle!
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }
    // Kirjojen poisto
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    

}
