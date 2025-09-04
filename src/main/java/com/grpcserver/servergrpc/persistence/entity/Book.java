package com.grpcserver.servergrpc.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;
}