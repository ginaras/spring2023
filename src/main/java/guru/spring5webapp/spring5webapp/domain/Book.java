package guru.spring5webapp.spring5webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn)//, Set<Author> autors) se scoate cand se face repositories
    {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAutors() {
        return authors;
    }

    public void setAutors(Set<Author> autors) {
        this.authors = autors;
    }
//toString implementation --> alt+ insert --> toString --> all
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autors=" + authors +
                '}';
    }// END toString implementation

    // equals and has code implementtion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
//end   equals and has code implementtion
}
