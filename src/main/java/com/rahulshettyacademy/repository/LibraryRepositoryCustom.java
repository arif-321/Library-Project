package com.rahulshettyacademy.repository;

import java.util.List;

import com.rahulshettyacademy.controller.Library;

public interface LibraryRepositoryCustom {

	List<Library>findAllByAuthor(String authorname);

}
