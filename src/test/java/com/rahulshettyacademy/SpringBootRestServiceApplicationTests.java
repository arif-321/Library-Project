package com.rahulshettyacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.rahulshettyacademy.controller.Library;
import com.rahulshettyacademy.controller.LibraryController;
import com.rahulshettyacademy.repository.Storage2;
import com.rahulshettyacademy.service.LibraryService;

@SpringBootTest
class SpringBootRestServiceApplicationTests {

	@Autowired
	LibraryController con;
	
	@MockBean
	Storage2 repository;
	
	@MockBean
	LibraryService libraryService;
	
	@Test
	void contextLoads() {
	}


@Test
public void checkBuildIDLogic()
{
	LibraryService lib=new LibraryService();
	String id = lib.buildId("ZMAN", 24);
	assertEquals(id,"OLDZMAN24");
	
	String id1 = lib.buildId("MAN", 24);
	assertEquals(id,"ZMAN24");
}

@Test
public void addBookTest()
{
	ResponseEntity response = con.addBookImplementation(buildLibrary());
	System.out.println(response.getStatusCode());  

}

public Library buildLibrary()
{
	Library lib = new Library();
	lib.setAisle(322);
	lib.setBook_name("Spring");
	lib.setIsbn("sfe");
	lib.setAuthor("Rahul Shetty");
	lib.setId("sfe322");
	return lib;
	
}

}