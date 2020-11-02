package com.tap.positiveingestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.positiveingestor.kafka.KafkaProducer;
import com.tap.positiveingestor.model.Message;
import com.tap.positiveingestor.service.LanguageDetectorService;

@RestController
@RequestMapping("/api/v1/send")
public class SendToKafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer; 
	
	@Autowired
	private LanguageDetectorService languageDetectorService;
	
	@PostMapping("/telegram-message")
	public boolean send(@RequestBody Message message) {
		String lang = languageDetectorService.getLanguage(message.getMessage());
		if (lang.equals("en"))
			kafkaProducer.produce("telegram-message", message);	
		else {
			System.out.println("Message discarded. Language is "+lang+". Not supported");
			return false;
		}
		return true; 
	}
}
