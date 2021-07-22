package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.BookCategory;
import com.library.services.BookCategoryService;

@RestController
public class BookCategoryController {
	
	@Autowired
	private BookCategoryService bookCatService;
	
	@GetMapping("/categories")
	public List<BookCategory> categories() {
		return bookCatService.getAll();
	}
	
	@GetMapping("/categories/{id}")
	public BookCategory getCategory(@PathVariable("id") Long id) {
		return bookCatService.getBookCategory(id);
	}
	
	@PostMapping("/categories")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createCategory(@RequestBody BookCategory category) {
		bookCatService.save(category);
	}
	
	@PutMapping("/categories/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateCategory(@PathVariable("id") Long id, @RequestBody BookCategory category) {
		bookCatService.update(id, category);
	}
	
	@DeleteMapping("/categories/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable("id") Long id) {
		bookCatService.delete(id);
	}
}
