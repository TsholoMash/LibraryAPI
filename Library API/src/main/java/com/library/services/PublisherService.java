package com.library.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Publisher;
import com.library.repositories.PublisherDao;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherDao publisherDao;
	
	public List<Publisher> getAll() {
		
		List<Publisher> publishers = new ArrayList<>();
		publisherDao.findAll().forEach(publisher -> publishers.add(publisher));
		
		return publishers;
	}
	
	public Publisher getPublisher(Long id) {
		Optional<Publisher> bookCatOpt = publisherDao.findById(id);
		
		if(bookCatOpt.isPresent()) {
			return bookCatOpt.get();
		}
		return null;
	}
	
	public void save(Publisher publisher) {
		publisherDao.save(publisher);
	}
	
	public void update(Long id, Publisher publisher) {
		Optional<Publisher> publisherOpt = publisherDao.findById(id);
		
		if(publisherOpt.isPresent()) {
			Publisher publisherFromDB = publisherOpt.get();
			publisherFromDB.setName(publisher.getName());
			publisherFromDB.setLastModified(new Timestamp(new Date().getTime()));
			publisherDao.save(publisherFromDB);
		}
	}
	
	public void delete(Long id) {
		publisherDao.deleteById(id);
	}
}
