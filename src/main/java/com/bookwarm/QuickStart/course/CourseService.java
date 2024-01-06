package com.bookwarm.QuickStart.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course>  getAllCourse(String id) {
		ArrayList<Course> topics = new ArrayList<Course>();
		courseRepository.findTopicById(id).forEach(topics::add);;
		return topics;
	}
	
	public  ResponseEntity<Course> getCourse(String id) {
		Course data  = courseRepository.findById(id).get(); 
		return ResponseEntity.ok(data);
	}
	
	public  ResponseEntity<String> addCourse(Course course) {
		courseRepository.save(course);
		return ResponseEntity.ok("Successful");
	}
	
	public ResponseEntity<String> updateCourse(Course topic) { 
		courseRepository.save(topic);
		return ResponseEntity.ok("Successful");
		
	}
	
	public ResponseEntity<String> deleteCourse(String id) {
		courseRepository.deleteById(id);
		return ResponseEntity.ok("Successful");
		
	}

}
