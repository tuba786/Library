package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BookPublisher;

public interface BookPublisherRepo extends JpaRepository<BookPublisher, Integer> {

}
