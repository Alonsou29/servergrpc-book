package com.grpcserver.servergrpc.services;


import com.grpcserver.servergrpc.persistence.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    List<Book> findBooksByAuthorId(Integer id);

    Book findByName(String name);

    void saveBook(Book book);

    void deleteBookById(Integer id);

    Book findBookById(Integer id);
}
