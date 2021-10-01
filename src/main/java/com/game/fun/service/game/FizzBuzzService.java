package com.game.fun.service.game;

import com.game.fun.domain.FizzBuzzGameResult;
import com.game.fun.domain.FizzBuzzInputRequest;

public interface FizzBuzzService {
    FizzBuzzGameResult startGameAndFetchResults(FizzBuzzInputRequest fizzBuzzInputRequest);
}
