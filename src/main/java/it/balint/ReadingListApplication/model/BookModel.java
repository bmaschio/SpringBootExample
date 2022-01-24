package it.balint.ReadingListApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.balint.ReadingListApplication.entity.BookEntity;

public class BookModel {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name ;
    @JsonProperty("ISBN")
    private String  ISBN ;
    @JsonProperty("readme")
    private boolean readme ;


    public BookModel() {
    }

    public BookModel(Long id, String name, String ISBN, boolean readme) {
        this.id = id;
        this.name = name;
        this.ISBN = ISBN;
        this.readme = readme;
    }

    public BookModel(String name, String ISBN, boolean readme) {
        this.name = name;
        this.ISBN = ISBN;
        this.readme = readme;
    }


    public BookModel (BookEntity bookEntity){
        this.id = bookEntity.id();
        this.name = bookEntity.name();
        this.ISBN = bookEntity.ISBN();
        this.readme = bookEntity.readme();
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

    public void readme(boolean readme) {
        this.readme = readme;
    }

    public Long id() {
        return id;
    }

    public void id(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Entity {\n");

        sb.append("    id: ").append(id).append("\n");
        sb.append("    name: ").append(name).append("\n");
        sb.append("    ISBN: ").append(ISBN).append("\n");
        sb.append("    readme: ").append(readme).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
