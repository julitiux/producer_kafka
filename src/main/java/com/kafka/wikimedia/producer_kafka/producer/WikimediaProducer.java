package com.kafka.wikimedia.producer_kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikimediaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    kafkaTemplate.send("wikimedia-stream", message);
  }
}
