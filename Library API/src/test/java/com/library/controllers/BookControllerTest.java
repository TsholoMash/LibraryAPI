package com.library.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.entities.Book;
import com.library.services.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
    ObjectMapper mapper;
    
    @MockBean
    BookService bookService;
    

    Book BOOK1 = new Book("The times");
    Book BOOK2 = new Book("The names");
    
	@Test
	public void testGetAll() throws Exception {
		List<Book> records = new ArrayList<>(Arrays.asList(BOOK1, BOOK2));
	    
	    Mockito.when(bookService.getAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/books")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[1].title", is("The times")));
	}
}
