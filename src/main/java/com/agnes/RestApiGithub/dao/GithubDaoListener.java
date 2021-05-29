package com.agnes.RestApiGithub.dao;

import com.agnes.RestApiGithub.aop.LogRequest;
import com.agnes.RestApiGithub.dao.repository.GithubDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
class GithubDaoListener implements ApplicationListener<LogRequest> {
    private final GithubDaoRepository githubDaoRepository;
    private final Logger logger = LoggerFactory.getLogger(GithubDaoListener.class);

    public GithubDaoListener(GithubDaoRepository githubDaoRepository) {
        this.githubDaoRepository = githubDaoRepository;
    }

    @Override
    public void onApplicationEvent(LogRequest logRequest) {
        String login = logRequest.getLogin();
        logger.info("Starting GithubDaoListener.onApplicationEvent login: " + logRequest.getLogin());
        GithubDao request = githubDaoRepository.findByLogin(login).orElse(new GithubDao(login));
        request.increaseRequestCount();
        githubDaoRepository.save(request);
    }
}
