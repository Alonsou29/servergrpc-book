package com.grpcserver.servergrpc.services;

import com.grpcserver.servergrpc.persistence.entity.Author;
import com.grpcserver.servergrpc.persistence.repository.AuthorRepository;
import com.grpcserver.servergrpc.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        Author findAuthor = authorRepository.findById(author.getId()).orElse(null);
        if (findAuthor == null) {
            authorRepository.save(author);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Author findAuthorById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteAuthorById(Integer id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            bookRepository.deleteById(id);
            authorRepository.delete(author);
        }
    }
}
