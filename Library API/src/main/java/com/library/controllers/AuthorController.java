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

import com.library.entities.Author;
import com.library.services.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> authors() {
		return authorService.getAll();
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable("id") Long id) {
		return authorService.getAuthor(id);
	}
	
	@PostMapping("/authors")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createAuthor(@RequestBody Author author) {
		authorService.save(author);
	}
	
	@PutMapping("/authors/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
		authorService.update(id, author);
	}
	
	@DeleteMapping("/authors/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAuthor(@PathVariable("id") Long id) {
		authorService.delete(id);
	}
}
