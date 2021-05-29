package com.agnes.RestApiGithub.calculation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Calculation {

    private final Logger logger = LoggerFactory.getLogger(Calculation.class);

    public Optional<Integer> calculationValue(int followers, int publicRepos) {
        logger.info("Starting Calculation.calculationValue followers: " + followers + ", publicRepos: " + publicRepos);
        try {
            return Optional.of(6 / followers * (2 + publicRepos));
        } catch (ArithmeticException e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
