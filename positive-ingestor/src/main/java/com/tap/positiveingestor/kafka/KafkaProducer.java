package com.tap.positiveingestor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tap.positiveingestor.model.Message;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	public void produce(String topic, Message message) {
		System.out.println("Sto scrivendo nel topic "+ topic + " il messaggio "+message.getMessage());
		kafkaTemplate.send(topic, message);
	}

}
