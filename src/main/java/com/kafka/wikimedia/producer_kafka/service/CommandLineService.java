package com.kafka.wikimedia.producer_kafka.service;

import com.kafka.wikimedia.producer_kafka.stream.WikimediaStreamConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineService implements CommandLineRunner {

  private final WikimediaStreamConsumer wikimediaStreamConsumer;

  public CommandLineService(WikimediaStreamConsumer wikimediaStreamConsumer) {
    this.wikimediaStreamConsumer = wikimediaStreamConsumer;
  }

  @Override
  public void run(String... args) throws Exception {

    log.info("Wikimedia stream consumer started");
    wikimediaStreamConsumer.consumeStreamAndPublish();
  }
}