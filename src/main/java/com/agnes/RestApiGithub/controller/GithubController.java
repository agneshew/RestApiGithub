package com.agnes.RestApiGithub.controller;

import com.agnes.RestApiGithub.dto.GithubDto;
import com.agnes.RestApiGithub.service.GithubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping(value = "/{login}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<GithubDto>> getUserInformation(@PathVariable String login){
        GithubDto user = githubService.getGithubForUser(login);
        return new ResponseEntity(Mono.just(user), HttpStatus.OK);


    }
}
