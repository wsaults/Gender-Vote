package com.wsaults.gendervote;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;

@SpringBootApplication
public class GenderVoteApplication {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(GenderVoteApplication.class, args);
	}

	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilterVote() {
		return new HiddenHttpMethodFilter();
	}
}
