package com.tap.positiveingestor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tap.positiveingestor.model.Message;

@Service
public class ActionsList {

	private List<Message> actions;

	public ActionsList() {
		actions = new ArrayList<>();
	}

	public void addAction(Message message) {
		actions.add(message);
	}

	public List<Message> getAndRemoveActionByPlatform(String platform) {
		List<Message> actionsFilterByPlatform = actions.stream()
				.filter(x -> x.getPlatform().equals(platform))
				.collect(Collectors.toList());
		actions.removeAll(actionsFilterByPlatform);
		return actionsFilterByPlatform; 
	}
}
