package it.balint.ReadingListApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GetBooksModel {
    @JsonProperty("books")
    List<BookModel> bookEntities = new ArrayList<>();

    public void addBook(BookModel book){
      bookEntities.add(book);
    }
}
