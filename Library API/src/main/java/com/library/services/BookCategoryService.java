package com.library.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.BookCategory;
import com.library.repositories.BookCategoryDao;

@Service
public class BookCategoryService {
	
	@Autowired
	private BookCategoryDao bookCategoryDao;
	
	public List<BookCategory> getAll() {
		
		List<BookCategory> bookCategories = new ArrayList<>();
		bookCategoryDao.findAll().forEach(bookCategory -> bookCategories.add(bookCategory));
		
		return bookCategories;
	}
	
	public BookCategory getBookCategory(Long id) {
		Optional<BookCategory> bookCatOpt = bookCategoryDao.findById(id);
		
		if(bookCatOpt.isPresent()) {
			return bookCatOpt.get();
		}
		return null;
	}
	
	public void save(BookCategory bookCategory) {
		bookCategoryDao.save(bookCategory);
	}
	
	public void update(Long id, BookCategory bookCategory) {
		Optional<BookCategory> bookCatOpt = bookCategoryDao.findById(id);
		
		if(bookCatOpt.isPresent()) {
			BookCategory bookCatFromDB = bookCatOpt.get();
			bookCatFromDB.setName(bookCategory.getName());
			bookCatFromDB.setLastModified(new Timestamp(new Date().getTime()));
			bookCategoryDao.save(bookCatFromDB);
		}
	}
	
	public void delete(Long id) {
		bookCategoryDao.deleteById(id);
	}
}
