package com.kafka.wikimedia.producer_kafka.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class WikimediaStreamConsumer {

  private final WebClient webClient;

  public WikimediaStreamConsumer(WebClient webClient) {
    this.webClient = webClient;
  }
}
