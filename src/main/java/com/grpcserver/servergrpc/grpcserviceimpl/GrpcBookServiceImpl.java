package com.grpcserver.servergrpc.grpcserviceimpl;

import com.grpcserver.servergrpc.services.BookService;
import grpc.server.server.g.BookId;
import grpc.server.server.g.BookObject;
import grpc.server.server.g.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class GrpcBookServiceImpl extends BookServiceGrpc.BookServiceImplBase {
    @Autowired
    private BookService bookService;

    @Override
    public void findByName(BookId request, StreamObserver<BookObject> responseObserver) {
        super.findByName(request, responseObserver);
    }
}
