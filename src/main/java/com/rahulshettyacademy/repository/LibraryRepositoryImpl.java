package com.rahulshettyacademy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rahulshettyacademy.controller.Library;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom {
	
	@Autowired
	Storage2 repository;

	@Override
	public List<Library> findAllByAuthor(String authorName) {
		List<Library>booksWithAuthor = new ArrayList<Library>();
		// TODO Auto-generated method stub
		List<Library>books=repository.findAll();
		for(Library item : books)
		{
			if(item.getAuthor().equalsIgnoreCase(authorName))
			{
				booksWithAuthor.add(item);	
			}
		}
		return booksWithAuthor;
	}

}
