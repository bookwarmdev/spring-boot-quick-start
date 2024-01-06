package com.bookwarm.QuickStart.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookwarm.QuickStart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{id}/course")
	public List<Course> getAllCourse(@PathVariable String id) {
		return courseService.getAllCourse(id);
	}
	
	@GetMapping("/topics/{topicId}/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{id}/course")
	public ResponseEntity<String> addCourse(@RequestBody Course course, @PathVariable String id) {
		Topic topic = new Topic(id, "", "");
		course.setTopic(topic);
		return courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/course/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
		Topic topic = new Topic(topicId, "", "");
		course.setTopic(topic);
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicId}/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}
	

}
