package com.game.fun.evaluators;

import com.game.fun.domain.FizzBuzzType;

import java.util.Optional;
import java.util.function.Predicate;

public class FizzBuzzPredicates {

    public static final Optional<String> FIZZ_OPT = Optional.of(FizzBuzzType.FIZZ.getDisplay());
    public static final Optional<String> BUZZ_OPT = Optional.of("Buzz");
    public static final Optional<String> FIZZ_BUZZ_OPT = Optional.of("FizzBuzz");

    public static final Predicate<Integer> DIV_BY_3 = n -> n % 3 == 0;
    public static final Predicate<Integer> DIV_BY_5 = n -> n % 5 == 0;

    public static final Predicate<Integer> FIZZ_PREDICATE_V1 = DIV_BY_3.and(DIV_BY_5.negate());
    public static final Predicate<Integer> BUZZ_PREDICATE_V1 = DIV_BY_5.and(DIV_BY_3.negate());

    public static final Predicate<Integer> CONTAINS_3 = n -> Integer.toString(n).contains("3");
    public static final Predicate<Integer> CONTAINS_5 = n -> Integer.toString(n).contains("5");

    public static final Predicate<Integer> CONTAINS_3_NOT_5 = CONTAINS_3.and(CONTAINS_5.negate());
    public static final Predicate<Integer> CONTAINS_5_NOT_3 = CONTAINS_5.and(CONTAINS_3.negate());

    public static final Predicate<Integer> FIZZ_PREDICATE_V2 = FIZZ_PREDICATE_V1.or(CONTAINS_3_NOT_5);
    public static final Predicate<Integer> BUZZ_PREDICATE_V2 = BUZZ_PREDICATE_V1.or(CONTAINS_5_NOT_3);

    public static final Predicate<Integer> DIV_BY_15 = n -> n % 15 == 0;

    public static final Predicate<Integer> FIZZ_BUZZ_V2_PREDICATE = (DIV_BY_3.or(CONTAINS_3)).and(DIV_BY_5.or(CONTAINS_5));

}
