package com.agnes.RestApiGithub.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
final class GithubExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GithubExceptionHandler.class);

    @ExceptionHandler(GithubServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String githubServiceHandler(GithubServiceException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }
    @ExceptionHandler(LoginNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(LoginNotFound e) {
        logger.error(e.getMessage());
        return e.getMessage();}

}

