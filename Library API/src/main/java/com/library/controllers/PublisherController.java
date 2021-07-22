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

import com.library.entities.Publisher;
import com.library.services.PublisherService;

public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/publishers")
	public List<Publisher> publishers() {
		return null;
	}
	
	@GetMapping("/publishers/{id}")
	public Publisher getPublisher(@PathVariable("id") Long id) {
		return publisherService.getPublisher(id);
	}
	
	@PostMapping("/publishers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createPublisher(@RequestBody Publisher publisher) {
		publisherService.save(publisher);
	}
	
	@PutMapping("/publishers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void updatePublisher(@PathVariable("id") Long id, @RequestBody Publisher publisher) {
		publisherService.update(id, publisher);
	}
	
	@DeleteMapping("/publishers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletePublisher(@PathVariable("id") Long id) {
		publisherService.delete(id);
	}
}
