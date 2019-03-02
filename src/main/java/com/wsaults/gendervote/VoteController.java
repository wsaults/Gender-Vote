package com.wsaults.gendervote;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
  private final VoteRepository repository;

	public VoteController(VoteRepository repository) {
		this.repository = repository;
	}
}