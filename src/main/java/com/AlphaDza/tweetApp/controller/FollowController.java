package com.AlphaDza.tweetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AlphaDza.tweetApp.responses.ApiResponse;
import com.AlphaDza.tweetApp.service.FollowService;

@Controller
@RequestMapping("/tweety")
public class FollowController {
	
	@Autowired
	private ApiResponse apiResponse;
	@Autowired
	FollowService followService;
	
	@PostMapping(path = "follow/user/{user_id}", produces = "application/json")
	public ResponseEntity<Object> addFollowee(
			Authentication authentication, 
			@PathVariable("user_id") long user_id
	) throws Exception
	{			    		
		followService.followUser(authentication, user_id);
	    apiResponse.setMessage("Followee Added!");
	    apiResponse.setData(user_id);

		return new ResponseEntity<>(apiResponse.getBodyResponse(),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "unfollow/user/{user_id}", produces = "application/json")
	public ResponseEntity<Object> deleteFollowee(
			Authentication authentication, 
			@PathVariable("user_id") long user_id
	) throws Exception
	{
		followService.unfollowUser(authentication, user_id);
	    apiResponse.setMessage("Followee Added!");
	    apiResponse.setData(user_id);

		return new ResponseEntity<>(apiResponse.getBodyResponse(),HttpStatus.CREATED);
	}
}
