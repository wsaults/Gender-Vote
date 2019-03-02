package com.wsaults.gendervote;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VoteService {
  
  private final VoteRepository voteRepository;

  public VoteService(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }
  
  @Bean
  CommandLineRunner setUpVoteService() throws IOException {
    return (args) -> {
      // voteRepository.deleteAll().subscribe();
    };
  }

  public Flux<Vote> findAllVotes() {
		return voteRepository.findAll().log("findAllVotes");
  }

  public Mono<Long> getVotesCount() {
		return voteRepository.count();
  }
  
  public Flux<Vote> findByGender(String gender) {
		return voteRepository.findByGender(gender);
	}

	public Mono<Void> save(Vote newVote) {
    return voteRepository.save(newVote).then();
	}
}