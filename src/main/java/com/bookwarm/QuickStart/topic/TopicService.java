package com.bookwarm.QuickStart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic>  getAllTopics() {
		ArrayList<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);;
		return topics;
	}
	
	public  ResponseEntity<Topic> getTopic(String id) {
		Topic data  = topicRepository.findById(id).get();
//		Topic data = topics.stream().filter(t -> t.getId().toLowerCase().equals(id.toLowerCase())).findFirst().get();
		return ResponseEntity.ok(data);
	}
	
	public  ResponseEntity<String> addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
		return ResponseEntity.ok("Successful");
	}
	
	public ResponseEntity<String> updateTopic(String id, Topic topic) {
//		for(int i = 0; i <= topics.size(); i++) {
//			if(topics.get(i).getId().toLowerCase().equals(id.toLowerCase())) {
//				topics.set(i, topic);
//				return ResponseEntity.ok("Successful");
//			}
//		}
		topicRepository.save(topic);
		return ResponseEntity.ok("Successful");
		
	}
	
	public ResponseEntity<String> deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().toLowerCase().equals(id.toLowerCase()));
		topicRepository.deleteById(id);
		return ResponseEntity.ok("Successful");
		
	}

}
