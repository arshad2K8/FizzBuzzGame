package com.game.fun.service.sequence;

import com.game.fun.domain.FizzBuzzInputRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class SequenceGenerator {

    public Stream<Integer> getSequence(FizzBuzzInputRequest fizzBuzzInputRequest) {
        if (fizzBuzzInputRequest.getSequenceStrategy() == null) {
            return SequenceStrategy.SIMPLE.getSequenceStream(fizzBuzzInputRequest.getStartLimit(), fizzBuzzInputRequest.getEndLimit());
        } else {
            return fizzBuzzInputRequest.getSequenceStrategy().getSequenceStream(fizzBuzzInputRequest.getStartLimit(), fizzBuzzInputRequest.getEndLimit());
        }
    }
}
