package it.balint.ReadingListApplication.connectors;

import it.balint.ReadingListApplication.entity.BookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository <BookEntity, Long> {
    public List<BookEntity> findByISBN(String ISBN);

}
