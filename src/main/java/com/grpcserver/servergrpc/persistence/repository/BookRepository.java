package com.grpcserver.servergrpc.persistence.repository;

import com.grpcserver.servergrpc.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> deleteBooksByAuthorId(Integer id);
    List<Book> findBooksByAuthorId(Integer id);
    Book findBookByTitle(String title);
    Book findBookById(Integer id);
}

