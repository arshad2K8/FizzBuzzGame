package com.game.fun.evaluators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.game.fun.evaluators.FizzBuzzPredicates.*;

public class EvaluatorsV2Test {

    @Test
    public void testFizzEvaluatorV2() {
        Evaluator fizzEvaluatorV2 = Evaluator.FizzEvaluatorV2;
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV2.evaluate(3));     // divisble by 3
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV2.evaluate(34));    // contains 3
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV2.evaluate(43));
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV2.evaluate(1234));
        Assertions.assertEquals(FIZZ_OPT, fizzEvaluatorV2.evaluate(99));    // divisble by 3
        Assertions.assertEquals(Optional.empty(), fizzEvaluatorV2.evaluate(123450));  // divisible by 3 and 5 , contains 3 and 5 ==> should emit empty
    }

    @Test
    public void testBuzzEvaluatorV2() {
        Evaluator buzzEvaluatorV2 = Evaluator.BuzzEvaluatorV2;
        Assertions.assertEquals(BUZZ_OPT, buzzEvaluatorV2.evaluate(5));
        Assertions.assertEquals(BUZZ_OPT, buzzEvaluatorV2.evaluate(20));
        Assertions.assertEquals(BUZZ_OPT, buzzEvaluatorV2.evaluate(5551));
        Assertions.assertEquals(Optional.empty(), buzzEvaluatorV2.evaluate(111));
        Assertions.assertEquals(Optional.empty(), buzzEvaluatorV2.evaluate(123450));
    }

    @Test
    public void testFizzBuzzEvaluatorV2() {
        Evaluator fizzBuzzEvaluatorV2 = Evaluator.FizzBuzzEvaluatorV2;
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzEvaluatorV2.evaluate(123450));
    }
    

    @Test
    public void testFizzBuzzGameEvaluatorsV2() {
        Evaluator fizzBuzzGameEvaluatorsV2 = Evaluator.FizzBuzzGameEvaluatorsV2;
        Assertions.assertEquals(Optional.of("1"), fizzBuzzGameEvaluatorsV2.evaluate(1));
        Assertions.assertEquals(Optional.of("2"), fizzBuzzGameEvaluatorsV2.evaluate(2));

        // should return FIZZ for multiples of 3 or if Contains 3 only
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(3));
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(6));
        Assertions.assertEquals(FIZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(33));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(11130));

        // should return BUZZ for multiples of 5 or contains
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(5));
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(10));
        Assertions.assertEquals(BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(11156));

        // should return FIZZ_BUZZ for multiples of 15
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(15));
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(75));
        // 11130 multiple of 3 and 5
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(11130));
        // should return FIZZ_BUZZ if num contains 3 and 5
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(123451));
        // 1251 multiple of 3 and contains 5
        Assertions.assertEquals(FIZZ_BUZZ_OPT, fizzBuzzGameEvaluatorsV2.evaluate(1251));

        // should return num as is if no match
        Assertions.assertEquals(Optional.of("121"), fizzBuzzGameEvaluatorsV2.evaluate(121));
        Assertions.assertEquals(Optional.of("1111"), fizzBuzzGameEvaluatorsV2.evaluate(1111));
    }
}

