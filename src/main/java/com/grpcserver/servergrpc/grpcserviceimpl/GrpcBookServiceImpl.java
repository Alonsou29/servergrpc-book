package com.grpcserver.servergrpc.grpcserviceimpl;

import com.grpcserver.servergrpc.persistence.entity.Book;
import com.grpcserver.servergrpc.services.BookService;
import grpc.server.server.g.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@GrpcService
public class GrpcBookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    @Autowired
    private BookService bookService;

    @Override
    public void findByName(BookId request, StreamObserver<BookObject> responseObserver) {
        Book searchBook = bookService.findBookById((int) request.getId());

        BookObject objectBook = BookObject.newBuilder()
                .setId(searchBook.getId())
                .setTitle(searchBook.getTitle())
                .setPageCount(searchBook.getPageCount())
                .build();
        responseObserver.onNext(objectBook);
        responseObserver.onCompleted();
    }

    @Override
    public void allBooks(Empty request, StreamObserver<BookList> responseObserver) {
        List<Book> bookList = bookService.findAllBooks();
        List<BookObject> bookObjectList = new ArrayList<>();

        for (Book book : bookList) {
            BookObject bookAdd = BookObject.newBuilder()
                    .setId(book.getId())
                    .setTitle(book.getTitle())
                    .setPageCount(book.getPageCount())
                    .build();
            bookObjectList.add(bookAdd);
        }

        BookList.Builder bookListBuilder = BookList.newBuilder();

        for(BookObject bookO :  bookObjectList) {
            bookListBuilder.addBook(bookO);
        }

        responseObserver.onNext(bookListBuilder.build());
        responseObserver.onCompleted();
    }
}
