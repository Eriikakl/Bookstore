package hh.sof03.bookstore.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Float price;

    @ManyToOne
    @JsonIgnoreProperties ("books")
    @JoinColumn(name="categoryId")
    private Category category;

    public Book(String title, String author, Integer publicationYear, String isbn, Float price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Book() {
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + ", category=" + category + "]";
        else
            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
            }




    

    
    
}
