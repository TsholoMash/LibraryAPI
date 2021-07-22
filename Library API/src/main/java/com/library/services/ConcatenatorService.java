package com.library.services;

import org.springframework.stereotype.Service;

@Service
public class ConcatenatorService {
	
	public String generateFullName(String firstname, String surname) {
		return firstname + " " + surname;
	}
}
