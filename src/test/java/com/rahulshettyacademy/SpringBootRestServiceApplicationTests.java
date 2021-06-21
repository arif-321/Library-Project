package com.rahulshettyacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rahulshettyacademy.controller.AddResponse;
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
	
//	String id1 = lib.buildId("MAN", 24);
//	assertEquals(id,"MAN24");
}

@Test
public void addBookTest()
{
	//mock
	Library lib= buildLibrary();
	when(libraryService.buildId(lib.getIsbn(),lib.getAisle())).thenReturn(lib.getId());
	when(libraryService.checkBookAlreadyExist(lib.getId())).thenReturn(false);
	
	ResponseEntity response = con.addBookImplementation(buildLibrary());
	System.out.println(response.getStatusCode()); 
	assertEquals(response.getStatusCode(),HttpStatus.CREATED);
	AddResponse ad = (AddResponse) response.getBody();
	ad.getId();
	assertEquals(lib.getId(),ad.getId());
	assertEquals("Success book is added",ad.getMsg());

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