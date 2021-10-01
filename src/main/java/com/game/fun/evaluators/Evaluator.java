package com.game.fun.evaluators;

import java.util.Optional;

import static com.game.fun.evaluators.FizzBuzzPredicates.*;

public interface Evaluator {

    Optional<String> evaluate(Integer num);
    default Evaluator orElse(Evaluator evaluator) {
        return n -> this.evaluate(n).or(() -> evaluator.evaluate(n));
    }

    Evaluator FizzEvaluatorV1 = n -> FIZZ_PREDICATE_V1.test(n) ? FIZZ_OPT : Optional.empty();
    Evaluator BuzzEvaluatorV1 = n -> BUZZ_PREDICATE_V1.test(n) ? BUZZ_OPT : Optional.empty();
    Evaluator FizzBuzzEvaluatorV1 = n -> DIV_BY_15.test(n) ? FIZZ_BUZZ_OPT : Optional.empty();
    Evaluator NoOpEvaluator = n -> Optional.of(Integer.toString(n));
    Evaluator FizzBuzzGameEvaluatorsV1 = FizzBuzzEvaluatorV1.orElse(FizzEvaluatorV1).orElse(BuzzEvaluatorV1).orElse(NoOpEvaluator);

    Evaluator FizzEvaluatorV2 = n -> FIZZ_PREDICATE_V2.test(n) ? FIZZ_OPT : Optional.empty();
    Evaluator BuzzEvaluatorV2 = n -> BUZZ_PREDICATE_V2.test(n) ? BUZZ_OPT : Optional.empty();
    Evaluator FizzBuzzEvaluatorV2 = n -> FIZZ_BUZZ_V2_PREDICATE.test(n) ? FIZZ_BUZZ_OPT : Optional.empty();
    Evaluator FizzBuzzGameEvaluatorsV2 = FizzBuzzEvaluatorV2.orElse(FizzEvaluatorV2).orElse(BuzzEvaluatorV2).orElse(NoOpEvaluator);

}
