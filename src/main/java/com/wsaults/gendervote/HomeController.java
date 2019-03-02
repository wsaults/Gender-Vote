package com.wsaults.gendervote;

import java.util.UUID;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  private final VoteService voteService;

  // private static final String API_BASE_PATH = "/api";

  public HomeController(VoteService voteService) {
    this.voteService = voteService;
  }

  @GetMapping("/")
  public Mono<String> index(Model model) {
    model.addAttribute("girls", voteService.findByGender("girl"));
    model.addAttribute("boys", voteService.findByGender("boy"));
    return Mono.just("index");
  }

  @PostMapping("/votes/{gender}")
  public Mono<String> createVote(@PathVariable String gender) {
    return voteService.save(new Vote(UUID.randomUUID().toString(), gender)).then(Mono.just("redirect:/"));
  }
}