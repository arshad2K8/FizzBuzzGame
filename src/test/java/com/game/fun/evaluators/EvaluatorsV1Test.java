package com.game.fun.evaluators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.game.fun.evaluators.FizzBuzzPredicates.*;

public class EvaluatorsV1Test {

    @Test
    public void testFizzEvaluatorV1() {
        Evaluator fizzEvaluatorV1 = Evaluator.FizzEvaluatorV1;
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV1.evaluate(3));
        Assertions.assertEquals(Optional.empty(), fizzEvaluatorV1.evaluate(34));
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV1.evaluate(99));
        Assertions.assertEquals(Optional.empty(), fizzEvaluatorV1.evaluate(15));  // divisible by 3 and 5
        Assertions.assertEquals(Optional.empty(), fizzEvaluatorV1.evaluate(123450));  // divisible by 3 and 5
    }

    @Test
    public void testBuzzEvaluatorV1() {
        Evaluator buzzEvaluatorV1 = Evaluator.BuzzEvaluatorV1;
        Assertions.assertEquals(BUZZ_OPT, buzzEvaluatorV1.evaluate(5));
        Assertions.assertEquals(BUZZ_OPT, buzzEvaluatorV1.evaluate(20));
        Assertions.assertEquals(Optional.empty(), buzzEvaluatorV1.evaluate(5551));
        Assertions.assertEquals(Optional.empty(), buzzEvaluatorV1.evaluate(111));

        // should return empty since 123450 is multiple of 3 and 5
        Assertions.assertEquals(Optional.empty(), buzzEvaluatorV1.evaluate(123450));
    }


    @Test
    public void testFizzBuzzEvaluatorV1() {
        Evaluator fizzBuzzEvaluatorV1 = Evaluator.FizzBuzzEvaluatorV1;
        Assertions.assertEquals(Optional.empty(), fizzBuzzEvaluatorV1.evaluate(5));
        Assertions.assertEquals(Optional.empty(), fizzBuzzEvaluatorV1.evaluate(20));

        // should return FIZZ_BUZZ for multiples of 15
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzEvaluatorV1.evaluate(15));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzEvaluatorV1.evaluate(75));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzEvaluatorV1.evaluate(123450));
    }


    @Test
    public void testFizzBuzzGameEvaluatorsV1() {
        Evaluator fizzBuzzGameEvaluatorsV1 = Evaluator.FizzBuzzGameEvaluatorsV1;
        Assertions.assertEquals(Optional.of("1"), fizzBuzzGameEvaluatorsV1.evaluate(1));
        Assertions.assertEquals(Optional.of("2"), fizzBuzzGameEvaluatorsV1.evaluate(2));

        // should return FIZZ for multiples of 3 only
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(3));
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(6));
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(33));
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(111));

        // should return BUZZ for multiples of 5 only
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(5));
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(10));
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(25));

        // should return FIZZ_BUZZ for multiples of 15
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(15));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(75));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV1.evaluate(123450));

        // should return num as is if no match
        Assertions.assertEquals(Optional.of("5551"), fizzBuzzGameEvaluatorsV1.evaluate(5551));
        Assertions.assertEquals(Optional.of("1111"), fizzBuzzGameEvaluatorsV1.evaluate(1111));

    }

    @Test
    public void test() {
        System.out.println(111 % 3 == 0);
    }
}
