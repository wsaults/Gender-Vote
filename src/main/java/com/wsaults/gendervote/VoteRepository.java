package com.wsaults.gendervote;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VoteRepository extends ReactiveCrudRepository<Vote, String> {
  Flux<Vote> findByGender(String gender);

  Mono<Vote> save(Vote newVote);

  Flux<Vote> saveAll(Flux<Vote> newVote);

  Mono<Vote> findById(String id);

  Mono<Void> deleteAll();
}