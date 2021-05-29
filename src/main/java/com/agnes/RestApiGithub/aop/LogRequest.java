package com.agnes.RestApiGithub.aop;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public final class LogRequest extends ApplicationEvent {

    private final String login;

    public LogRequest(Object source, String login) {
        super(source);
        this.login = login;
    }
}
