package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

     // Kategorian listaus 
     // http://localhost:8080/categorylist
    @RequestMapping(value="/categorylist", method=RequestMethod.GET)
    public String categoryList(Model model) {
        
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }  

     // Kategorian lisäys
     // http://localhost:8080/addcategory
    @RequestMapping(value="/addcategory")
    public String addBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    // Tallenna uusi kategoria
    @RequestMapping(value="/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }

}
