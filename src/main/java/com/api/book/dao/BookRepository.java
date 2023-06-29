package com.api.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	// to get book by 'id'.
	public Book findByid(int id);

}
