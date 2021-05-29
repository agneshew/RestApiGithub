package com.agnes.RestApiGithub.webClient;

import lombok.Getter;

@Getter
public class GithubUserDto {
    private long id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private int public_repos;
    private int followers;
}
