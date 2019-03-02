package com.wsaults.gendervote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;

@SpringBootApplication
public class GenderVoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenderVoteApplication.class, args);
	}

	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilterVote() {
		return new HiddenHttpMethodFilter();
	}
}
