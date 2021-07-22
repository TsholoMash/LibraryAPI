package com.library.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.repositories.BookDao;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public List<Book> getAll() {
		
		List<Book> books = new ArrayList<>();
		bookDao.findAll().forEach(book -> books.add(book));
		
		return books;
	}
	
	public Book getBook(Long id) {
		Optional<Book> bookOpt = bookDao.findById(id);
		
		if(bookOpt.isPresent()) {
			return bookOpt.get();
		}
		return null;
	}
	
	public void save(Book book) {
		bookDao.save(book);
	}
	
	public void update(Long id, Book book) {
		Optional<Book> bookOpt = bookDao.findById(id);
		
		if(bookOpt.isPresent()) {
			Book bookFromDB = bookOpt.get();
			bookFromDB.setTitle(book.getTitle());
			bookFromDB.setLastModified(new Timestamp(new Date().getTime()));
			bookDao.save(bookFromDB);
		}
	}
	
	public void delete(Long id) {
		bookDao.deleteById(id);
	}
}
