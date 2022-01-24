package it.balint.ReadingListApplication.commands;

import it.balint.ReadingListApplication.connectors.BookRepository;
import it.balint.ReadingListApplication.entity.BookEntity;
import it.balint.ReadingListApplication.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component("getBook")
public class GetBook {
    @Autowired
    BookRepository bookRepository;

    protected boolean canExecute() throws ForbiddenException {
        return true;
    }

    private BookModel doExecute(long id) throws NoSuchElementException {
        /* doing something here */
        Optional<BookEntity> response = bookRepository.findById(id);
        return new BookModel(response.get());
    }

    public BookModel execute( long id) throws ForbiddenException , NoSuchElementException {
        BookModel bookModel = new BookModel();
        if (canExecute()) {

           bookModel=  doExecute(id);
        }
        return bookModel ;

    }
}
