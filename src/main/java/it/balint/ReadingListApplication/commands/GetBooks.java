package it.balint.ReadingListApplication.commands;

import it.balint.ReadingListApplication.connectors.BookRepository;
import it.balint.ReadingListApplication.model.GetBooksModel;
import it.balint.ReadingListApplication.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("getBooks")


public class GetBooks {

        @Autowired
        BookRepository bookRepository;

        protected boolean canExecute() throws ForbiddenException {
            return true;
        }

        private GetBooksModel doExecute()  {
            /* doing something here */
            GetBooksModel getBooksModel = new GetBooksModel();
            bookRepository.findAll().forEach(bookEntity -> {
                getBooksModel.addBook(new BookModel(bookEntity));
            });
            return getBooksModel;
        }


        public GetBooksModel execute() throws ForbiddenException {
            GetBooksModel getBooksModel = new GetBooksModel();
            if (canExecute()) {
                getBooksModel =  doExecute();
            }
            return getBooksModel;

        }
}
