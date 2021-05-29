package com.agnes.RestApiGithub.exception;


public class GithubServiceException extends RuntimeException {

    public GithubServiceException() {
        super("Service is unavailable.");
    }
}
