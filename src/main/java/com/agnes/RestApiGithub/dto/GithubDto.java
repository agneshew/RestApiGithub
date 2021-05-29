package com.agnes.RestApiGithub.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GithubDto {

    private long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;

    private Integer calcuations;

    @JsonIgnore
    private int followers;
    @JsonIgnore
    private int publicRepos;
}
