package com.kafka.wikimedia.producer_kafka.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class WikimediaStreamConsumer {

  private final WebClient webClient;

  public WikimediaStreamConsumer(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
  }
}
