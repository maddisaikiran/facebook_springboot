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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.exception.ValidationException;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Timeline;

import com.app.demo.service.TimelineService;
import com.app.demo.util.ResponseUtil;


@RestController
@CrossOrigin
public class TimelineController {

	@Autowired
	TimelineService timelineService;
	
	@PostMapping("/timeline/user/{userId}")
	public ResponseEntity<HttpStatusResponse> addTimeline(@RequestBody Timeline timeline,@PathVariable Integer userId) throws ValidationException{
		Timeline timeline2 = timelineService.addTimeline(timeline, userId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), timeline2, Constants.MESSAGE_TIMELINE_ADDED);
	}
	
	@GetMapping("/timelines")
	public ResponseEntity<HttpStatusResponse> getAllMyTimeline() {
		List<Timeline> timelines = timelineService.getAllMyTimeline();
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), timelines,"Timeline retrival");
	}
	
//	@GetMapping("/timelines/user/{id}")
//	public ResponseEntity <List<Timeline>> getAllMyTimelineById(@PathVariable Integer id){
//	List<Timeline> timelines = timelineService.getAllMyTimelineById(id);
//	return new ResponseEntity<List<Timeline>>(timelines, HttpStatus.CREATED);
//	}
	@GetMapping("/timelines/user/{id}")
	public ResponseEntity<HttpStatusResponse> getAllMyTimelineById(@PathVariable Integer id){
	List<Timeline> timelines = timelineService.getAllMyTimelineById(id);
	return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), timelines,"All User Timelines found" );
	}
	
	
	@GetMapping("/timeline/friend/{userId}")
	public List<Timeline> getUserByFriendByTimelineById(@PathVariable(value = "userId") Integer userId){
		          return timelineService.getUserByFriendByTimelineById(userId);
	}

	
	
	
}
