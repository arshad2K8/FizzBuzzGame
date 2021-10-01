package com.game.fun.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FizzBuzzResult {
    private Integer input;
    private String result;
}
