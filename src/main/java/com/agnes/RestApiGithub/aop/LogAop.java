package com.agnes.RestApiGithub.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
final class LogAop {

    private final Logger logger = LoggerFactory.getLogger(LogAop.class);
    private final ApplicationEventPublisher applicationEventPublisher;

    public LogAop(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(final String login) {
        logger.info("Starting LogAop.publish login: " + login);
        LogRequest logRequest = new LogRequest(this, login);
        applicationEventPublisher.publishEvent(logRequest);
    }

    @Before("execution(* com.agnes.RestApiGithub.controller.GithubController.getUserInformation(..))")
    private void incrementRequestCounter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String login = (String) args[0];
        logger.info("Starting LogAop.incrementRequestCounter login: " + login);
        publish(login);
    }


}

