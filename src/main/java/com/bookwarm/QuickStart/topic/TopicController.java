package com.bookwarm.QuickStart.topic;

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

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/")
	public String welcome() {
		return "It Working";
	}
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public ResponseEntity<String> updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		return topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public ResponseEntity<String> deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}
	

}
