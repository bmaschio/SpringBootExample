package it.balint.ReadingListApplication.commands;

import it.balint.ReadingListApplication.connectors.BookRepository;
import it.balint.ReadingListApplication.entity.BookEntity;
import it.balint.ReadingListApplication.model.BookModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("writeBook")
public class WriteBook {
    @Autowired
    BookRepository bookRepository;

    protected boolean canExecute() throws ForbiddenException {
        return true;
    }

    private BookModel doExecute(BookModel book) throws Exception {
        /* doing something here */
        BookEntity response = bookRepository.save(new BookEntity(book.name(), book.ISBN(), book.readme()));
        return new BookModel(response);
    }

    public BookModel execute( BookModel book) throws Exception {
        BookModel bookModel = new BookModel();
        if (canExecute()) {
           bookModel=  doExecute(book);
        }
        return bookModel ;

    }
}
