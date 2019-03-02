package com.wsaults.gendervote;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ApiController {

  // private static final Logger log = LoggerFactory.getLogger(ApiController.class);
  private static final String API_BASE_PATH = "/api";

  private final VoteService voteService;

	public ApiController(VoteService voteService) {
		this.voteService = voteService;
	}

  @GetMapping(API_BASE_PATH + "/votes/count")
  Mono<Long> votesCount() {
    return voteService.getVotesCount();
  }
  
  @GetMapping(API_BASE_PATH + "/votes/{gender}")
	public Flux<Vote> votes(@PathVariable String gender) {
		return voteService.findByGender(gender);
  }
  
  @PostMapping(API_BASE_PATH + "/votes/{gender}")
  Mono<Void> create(@PathVariable String gender) {
    return voteService.save(new Vote(UUID.randomUUID().toString(), gender));
  }
}