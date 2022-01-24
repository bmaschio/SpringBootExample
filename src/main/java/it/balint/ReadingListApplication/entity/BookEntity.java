package it.balint.ReadingListApplication.entity;

import it.balint.ReadingListApplication.model.BookModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name ;
    private String  ISBN ;
    private boolean readme ;

    public BookEntity(){}

    public BookEntity(String name, String isbn, boolean readme) {
        this.name = name;
        ISBN = isbn;
        this.readme = readme;
    }



    public Long id() {
        return id;
    }

    public void Id(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String ISBN() {
        return ISBN;
    }

    public void ISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean readme() {
        return readme;
    }

    public void setReadme(boolean readme) {
        this.readme = readme;
    }
}
