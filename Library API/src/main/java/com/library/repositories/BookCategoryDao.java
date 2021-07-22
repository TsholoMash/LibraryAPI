package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.BookCategory;

public interface BookCategoryDao extends CrudRepository<BookCategory, Long> {

}
