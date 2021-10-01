package com.game.fun.controller;

import com.game.fun.domain.FizzBuzzGameResult;
import com.game.fun.domain.FizzBuzzInputRequest;
import com.game.fun.service.game.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
@Slf4j
public class FizzBuzzController {
    private FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @PostMapping("/start")
    FizzBuzzGameResult startGame(@RequestBody FizzBuzzInputRequest fizzBuzzInputRequest) {
        log.info("Received request to start game {}", fizzBuzzInputRequest);
        return fizzBuzzService.startGameAndFetchResults(fizzBuzzInputRequest);
    }

}
