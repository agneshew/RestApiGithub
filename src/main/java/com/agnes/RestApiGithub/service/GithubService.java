package com.agnes.RestApiGithub.service;

import com.agnes.RestApiGithub.calculation.Calculation;
import com.agnes.RestApiGithub.dto.GithubDto;
import com.agnes.RestApiGithub.exception.GithubServiceException;
import com.agnes.RestApiGithub.exception.LoginNotFound;
import com.agnes.RestApiGithub.webClient.GithubUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class GithubService {

    private final Logger logger = LoggerFactory.getLogger(GithubService.class);

    private final WebClient webClient;
    private final Calculation calculation;
    @Value("${api.github.users}")
    private String githubUsersUrl;

    public GithubService(Calculation calculation) {
        this.calculation = calculation;
        this.webClient = WebClient.create();
    }

    public GithubDto getGithubForUser(String login) {
        logger.info("Starting GithubService.getGithubForUser login: " + login);
        GithubUserDto user;
        Mono<GithubUserDto> responseFromApi = webClient.get()
                .uri(githubUsersUrl + login)
                .retrieve()
                .bodyToMono(GithubUserDto.class);
        try {
            user = responseFromApi.block();
            int followers = user.getFollowers();
            int publicRepos = user.getPublic_repos();
            Integer calculatedValue = calculation.calculationValue(followers, publicRepos).orElse(null);
            return getGithubDto(user, calculatedValue);
        } catch (WebClientResponseException.NotFound e) {
            logger.error(e.getMessage());
            throw new LoginNotFound(login);
        } catch (WebClientRequestException e) {
            logger.error(e.getMessage());
            throw new GithubServiceException();
        }
    }

    public GithubDto getGithubDto(GithubUserDto githubUserDto, int calculations) {
        return new GithubDto(
                githubUserDto.getId(),
                githubUserDto.getLogin(),
                githubUserDto.getName(),
                githubUserDto.getType(),
                githubUserDto.getAvatar_url(),
                githubUserDto.getCreated_at(),
                githubUserDto.getFollowers(),
                githubUserDto.getPublic_repos(),
                calculations
        );
    }


}
