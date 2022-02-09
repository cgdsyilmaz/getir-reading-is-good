package com.example.getirreadingisgood.book.repository;

import com.example.getirreadingisgood.book.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends MongoRepository<Book, UUID> {
    Optional<Book> findBookByBookId(UUID bookId);
}
