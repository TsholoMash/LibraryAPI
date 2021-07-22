package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.Publisher;

public interface PublisherDao  extends CrudRepository<Publisher, Long> {

}
