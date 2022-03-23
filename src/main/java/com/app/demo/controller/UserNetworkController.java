package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.User;
import com.app.demo.model.UserDto;
import com.app.demo.service.FriendService;
import com.app.demo.service.UserSearchService;


@RestController
@CrossOrigin
public class UserNetworkController {
	@Autowired
	private UserSearchService userSearchService;
	
	@Autowired
	private FriendService service;
	
	@PostMapping("/users/network/")
	public ResponseEntity <List<UserDto>> getAllFriendForUser(@RequestBody Integer requestedUserId){
		List<UserDto> userDtos = userSearchService.getAllFriendForUser(requestedUserId);
		return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.CREATED);
	}
	

	
	
	@GetMapping("/friends/{friendId}")
	public ResponseEntity <List<User>> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
		List<User> users = service.getUserByFriendByOrderStatusById(friendId);
		return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
	}
	
	

}
