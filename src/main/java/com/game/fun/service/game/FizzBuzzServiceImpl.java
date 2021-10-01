package com.game.fun.service.game;

import com.game.fun.config.FizzBuzzInputConfig;
import com.game.fun.domain.FizzBuzzGameResult;
import com.game.fun.domain.FizzBuzzInputRequest;
import com.game.fun.domain.FizzBuzzResult;
import com.game.fun.evaluators.Evaluator;
import com.game.fun.service.sequence.SequenceGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private SequenceGenerator sequenceGenerator;
    private FizzBuzzEvaluatorStrategy fizzBuzzEvaluatorStrategy;

    public FizzBuzzServiceImpl(SequenceGenerator sequenceGenerator,
                               FizzBuzzEvaluatorStrategy fizzBuzzEvaluatorStrategy) {
        this.sequenceGenerator = sequenceGenerator;
        this.fizzBuzzEvaluatorStrategy = fizzBuzzEvaluatorStrategy;
    }


    @Override
    public FizzBuzzGameResult startGameAndFetchResults(FizzBuzzInputRequest fizzBuzzInputRequest) {
        Evaluator evaluator = fizzBuzzEvaluatorStrategy.fromGameVersion(fizzBuzzInputRequest.getGameVersion());
        List<FizzBuzzResult> fizzBuzzResults = sequenceGenerator.getSequence(fizzBuzzInputRequest)
                .map(inputToFizzBuzzResultMapper(evaluator))
                .collect(Collectors.toList());

        return FizzBuzzGameResult.builder().fizzBuzzResults(fizzBuzzResults)
                .gameVersion(fizzBuzzInputRequest.getGameVersion())
                .sequenceStrategy(fizzBuzzInputRequest.getSequenceStrategy())
                .build();
    }

    private Function<Integer, FizzBuzzResult> inputToFizzBuzzResultMapper(Evaluator evaluator) {
        return n -> {
            String fizzBuzzResult = evaluator.evaluate(n).orElse(Integer.toString(n));
            return FizzBuzzResult.builder().result(fizzBuzzResult).input(n).build();
        };
    }
}
