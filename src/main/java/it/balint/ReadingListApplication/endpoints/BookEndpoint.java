package it.balint.ReadingListApplication.endpoints;

import it.balint.ReadingListApplication.commands.ForbiddenException;
import it.balint.ReadingListApplication.commands.GetBook;
import it.balint.ReadingListApplication.commands.GetBooks;
import it.balint.ReadingListApplication.commands.WriteBook;
import it.balint.ReadingListApplication.model.BookModel;
import it.balint.ReadingListApplication.model.GetBooksModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
public class BookEndpoint {
    ArrayList<BookModel> books = new ArrayList<>();
    @Autowired
    private WriteBook writeBook;
    @Autowired
    private GetBooks getBooks;
    @Autowired
    private GetBook getBook;

    @GetMapping("/books")
    public ResponseEntity<GetBooksModel> readBooks() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(getBooks.execute());
    }

    @PostMapping("/books")
    public ResponseEntity<BookModel> createBook(@RequestBody BookModel book) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(writeBook.execute(book));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookModel> readBookById(@PathVariable long id)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getBook.execute(id));
        }catch (NoSuchElementException ex) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (ForbiddenException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

}
