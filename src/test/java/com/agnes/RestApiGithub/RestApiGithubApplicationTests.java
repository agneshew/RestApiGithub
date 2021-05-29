package com.agnes.RestApiGithub;

import com.agnes.RestApiGithub.dto.GithubDto;
import com.agnes.RestApiGithub.service.GithubService;
import com.agnes.RestApiGithub.webClient.GithubUserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class RestApiGithubApplicationTests {

	@Autowired
	GithubService githubService;
	GithubUserDto user;

	@Test
	public void testGetUserId() {
//		GithubService githubService ;
		//GithubUserDto user;
		GithubDto githubDto = githubService.getGithubForUser("bykowski");
		assertEquals(8548241l, user.getId());
	}
}
