package com.game.fun.service.game;

import com.game.fun.evaluators.Evaluator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzEvaluatorStrategy {

    public Evaluator fromGameVersion(String version) {
        if(StringUtils.isBlank(version)) {
            return Evaluator.FizzBuzzGameEvaluatorsV1;
        }

        switch (version.toUpperCase()) {
            case "V2":
                return Evaluator.FizzBuzzGameEvaluatorsV2;
            default:
                return Evaluator.FizzBuzzGameEvaluatorsV1;
        }
    }
}
