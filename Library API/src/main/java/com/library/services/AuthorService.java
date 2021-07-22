package com.library.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Author;
import com.library.repositories.AuthorDao;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private ConcatenatorService concatenatorService;
	
	public List<Author> getAll() {
		
		List<Author> authors = new ArrayList<>();
		authorDao.findAll().forEach(author -> authors.add(author));
		
		return authors.stream()
			.map(e -> new Author(e.getId(), e.getFirstname(), e.getSurname(), e.getDateCreated(), e.getLastModified(), e.getBooks(), concatenatorService.generateFullName(e.getFirstname(), e.getSurname())))
			.collect(Collectors.toList());
	}
	
	public Author getAuthor(Long id) {
		Optional<Author> authorOpt = authorDao.findById(id);
		
		if(authorOpt.isPresent()) {
			Author author =  authorOpt.get();
			author.setFullname(concatenatorService.generateFullName(author.getFirstname(), author.getSurname()));
			return author;
		}
		return null;
	}
	
	public void save(Author author) {
		authorDao.save(author);
	}
	
	public void update(Long id, Author author) {
		Optional<Author> authorOpt = authorDao.findById(id);
		
		if(authorOpt.isPresent()) {
			Author authorFromDB = authorOpt.get();
			authorFromDB.setFirstname(author.getFirstname());
			authorFromDB.setSurname(author.getSurname());
			authorFromDB.setLastModified(new Timestamp(new Date().getTime()));
			authorDao.save(authorFromDB);
		}
	}
	
	public void delete(Long id) {
		authorDao.deleteById(id);
	}
}