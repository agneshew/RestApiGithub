package com.agnes.RestApiGithub.dao.repository;

import com.agnes.RestApiGithub.dao.GithubDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GithubDaoRepository extends JpaRepository<GithubDao, String> {

    Optional<GithubDao> findByLogin(String login);
}
