package com.grpcserver.servergrpc.persistence.repository;

import com.grpcserver.servergrpc.persistence.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
}
