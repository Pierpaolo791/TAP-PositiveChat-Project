package com.tap.positiveingestor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tap.positiveingestor.model.Message;
import com.tap.positiveingestor.service.ActionsList;



@RestController
@RequestMapping("/api/v1/getAction")
public class ConsumeToKafkaController {
	
	@Autowired
	private ActionsList actionsList;
	
	@GetMapping("/telegram-action")
	public @ResponseBody ResponseEntity<List<Message>> getTelegramAction() {
		return ResponseEntity.ok(actionsList.getAndRemoveActionByPlatform("telegram"));
	}
	
	
}
