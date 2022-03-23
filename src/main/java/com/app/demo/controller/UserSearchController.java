package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.User;
import com.app.demo.service.UserSearchService;


@RestController
@CrossOrigin
public class UserSearchController {
	@Autowired
	private UserSearchService userSearchService;
	
	@GetMapping("/users")
	public ResponseEntity <List<User>> getAllUser(){
		List<User> users = userSearchService.getAllUser();
	return new ResponseEntity(users,HttpStatus.OK);
	}
	
//	@GetMapping("/users")
//	public  List<User> getAllUser(){
//		 
//	return userSearchService.getAllUser();
//	}
	
}
