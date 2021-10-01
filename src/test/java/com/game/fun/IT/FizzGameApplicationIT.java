package com.game.fun.IT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.fun.controller.FizzBuzzController;
import com.game.fun.domain.FizzBuzzGameResult;
import com.game.fun.domain.FizzBuzzInputRequest;
import com.game.fun.domain.FizzBuzzResult;
import com.game.fun.service.sequence.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("at")
class FizzGameApplicationIT {

	@LocalServerPort
	int randomServerPort;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private FizzBuzzController fizzBuzzController;

	@Test
	void contextLoads() {
		assertThat(fizzBuzzController).isNotNull();
	}

	@Test
	public void shouldStartV1FizzBuzzGameSuccessfully() throws Exception {
		FizzBuzzInputRequest fizzBuzzInputRequest = FizzBuzzInputRequest.builder().startLimit(1).endLimit(15).gameVersion("V1")
				.sequenceStrategy(SequenceStrategy.SIMPLE).build();
		FizzBuzzGameResult fizzBuzzGameResult = this.restTemplate.postForObject("http://localhost:" + randomServerPort + "/fizzbuzz/start", fizzBuzzInputRequest,
				FizzBuzzGameResult.class);
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(0), is(FizzBuzzResult.builder().input(1).result("1").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(1), is(FizzBuzzResult.builder().input(2).result("2").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(2), is(FizzBuzzResult.builder().input(3).result("Fizz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(3), is(FizzBuzzResult.builder().input(4).result("4").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(4), is(FizzBuzzResult.builder().input(5).result("Buzz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(14), is(FizzBuzzResult.builder().input(15).result("FizzBuzz").build()));
	}

	@Test
	public void shouldStartV2FizzBuzzGameSuccessfully() throws Exception {
		FizzBuzzInputRequest fizzBuzzInputRequest = FizzBuzzInputRequest.builder().startLimit(1).endLimit(52).gameVersion("V2")
				.sequenceStrategy(SequenceStrategy.SIMPLE).build();
		FizzBuzzGameResult fizzBuzzGameResult = this.restTemplate.postForObject("http://localhost:" + randomServerPort + "/fizzbuzz/start", fizzBuzzInputRequest,
				FizzBuzzGameResult.class);
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(0), is(FizzBuzzResult.builder().input(1).result("1").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(1), is(FizzBuzzResult.builder().input(2).result("2").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(2), is(FizzBuzzResult.builder().input(3).result("Fizz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(3), is(FizzBuzzResult.builder().input(4).result("4").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(12), is(FizzBuzzResult.builder().input(13).result("Fizz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(4), is(FizzBuzzResult.builder().input(5).result("Buzz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(14), is(FizzBuzzResult.builder().input(15).result("FizzBuzz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(50), is(FizzBuzzResult.builder().input(51).result("FizzBuzz").build()));
		assertThat(fizzBuzzGameResult.getFizzBuzzResults().get(51), is(FizzBuzzResult.builder().input(52).result("Buzz").build()));
	}
}
