package com.game.fun.domain;

public enum FizzBuzzType {
    FIZZ("Fizz"), BUZZ("Buzz"), FIZZ_BUZZ("FizzBuzz");

    private String display;

    FizzBuzzType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
