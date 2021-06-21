package com.rahulshettyacademy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahulshettyacademy.controller.Library;
import com.rahulshettyacademy.repository.Storage2;

@Service
public class LibraryService {
	
	@Autowired
	Storage2 repository;
	
	public String buildId(String isbn, int aisle)
	{
		if(isbn.startsWith("Z"))
		{
			return "OLD"+isbn+aisle;
		}
		
		return isbn+aisle;
	}
	public boolean checkBookAlreadyExist(String id)
	{
		Optional<Library> lib=repository.findById(id);
		if(lib.isPresent())
			return true;
		else
			return false;
	}

}