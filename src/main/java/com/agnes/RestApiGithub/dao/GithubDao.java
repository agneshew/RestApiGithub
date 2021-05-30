package com.agnes.RestApiGithub.dao;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
@NoArgsConstructor
public class GithubDao {

    @Id
    private String login;
    private int requestCount;

    public GithubDao(String login) {
        this.login = login;
    }

    public void increaseRequestCount() {
        this.requestCount = requestCount+1;
    }
}
