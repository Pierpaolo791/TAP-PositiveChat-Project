package com.tap.positiveingestor.kafka;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tap.positiveingestor.model.Message;
import com.tap.positiveingestor.service.ActionsList;

@Service
public class KafkaConsumer {
	
	@Autowired
	private ActionsList actionsList;

	@KafkaListener(topics = "telegram-action")
	public void consume(Message message) throws IOException {
		CompletableFuture.runAsync(() -> {
			actionsList.addAction(message);
			System.out.println("E' stata inserita un'azione");
		});
	}

}
