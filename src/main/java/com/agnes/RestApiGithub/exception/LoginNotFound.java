package com.agnes.RestApiGithub.exception;

public class LoginNotFound extends RuntimeException {

    public LoginNotFound(String login) {
        super(login + " not found");
    }
}
