package com.kafka.wikimedia.producer_kafka.stream;

import com.kafka.wikimedia.producer_kafka.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class WikimediaStreamConsumer {

  private final WebClient webClient;
  private final WikimediaProducer wikimediaProducer;

  public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
    this.webClient = webClientBuilder
      .baseUrl("https://stream.wikimedia.org/v2")
      .build();
    this.wikimediaProducer = wikimediaProducer;
  }

  public void consumeStreamAndPublish() {

    webClient.get()
      .uri("/stream/recentchange")
      .retrieve()
      .bodyToFlux(String.class)
      .subscribe(wikimediaProducer::sendMessage);
  }
}
