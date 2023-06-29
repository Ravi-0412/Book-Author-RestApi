package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component  // to tell spring that we want object of this class in case we do 'Autowire' and all.
public class BookService {
	
//	private static List<Book> list= new ArrayList<>();
//	
//	static {
//		list.add(new Book(12, "Java Complete Reference", "XYZ"));
//		list.add(new Book(36,"First Head to Java", "ABC"));
//		list.add(new Book(1552, "Think in Java", "LMN"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	// get all books 
//	public List<Book> getAllBooks() {
//		return list;
//	}
	
	// get also books using db
	public List<Book> getAllBooks() {
		List<Book> list= (List<Book>)bookRepository.findAll();
		return list;
}
	
//	// get single book by id
//	public Book getBookByid(int id) {
//		Book book = null;
//		try {
//		// doing directly instead of searching one by one
//		book = list.stream().filter(e->e.getId()== id).findFirst().get();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return book;
//	}

	// get single book by id using db
	public Book getBookByid(int id) {
		Book book = null;
		try {
		// doing directly instead of searching one by one
		book = bookRepository.findByid(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
//	public Book addBook(Book b) {
//		list.add(b);
//		return b;
//	}

	//adding the book using db
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}	

//	// delete Book
//	public void deleteBook(int bid) {
//		// all book whose id will not match will come into this list.
//		// so all books having given id 'bid' will get deleted.
//		list = list.stream().filter(book ->book.getId()!= bid).collect(Collectors.toList());
//	}

	// delete Book using db
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
	//update the book
//	public void updateBook(Book book, int id) {
//		// first we will search the book with given id, then update that book details with 'book'.
//		// map ek ko traverse karega and book wala object hi return karega.
//		// but we can change when we will find the book with given 'id'.
//		list.stream().map(b -> {
//			if(b.getId()== id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
//		
//		
//	}

	//update the book using db
		public void updateBook(Book book, int id) {
			book.setId(id);  //in case ids are same then first change the id of book
			bookRepository.save(book);  // save will also update
		
		}

}
