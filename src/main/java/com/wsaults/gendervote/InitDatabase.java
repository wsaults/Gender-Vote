package com.wsaults.gendervote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {
  @Bean
  CommandLineRunner init(MongoOperations operations) {
    return args -> {
      operations.dropCollection(Vote.class);

      // operations.insert(new Vote("1", "boy"));
      // operations.insert(new Vote("2", "girl"));
      // operations.insert(new Vote("3", "girl"));

      operations.findAll(Vote.class).forEach(vote -> {
        System.out.println(vote.toString());
      });
    };
  }
}