package com.game.fun.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.game.fun.config.FizzBuzzInputConfig;
import com.game.fun.domain.FizzBuzzGameResult;
import com.game.fun.domain.FizzBuzzInputRequest;
import com.game.fun.evaluators.Evaluator;
import com.game.fun.service.game.FizzBuzzEvaluatorStrategy;
import com.game.fun.service.game.FizzBuzzService;
import com.game.fun.service.game.FizzBuzzServiceImpl;
import com.game.fun.service.sequence.SequenceGenerator;
import com.game.fun.service.sequence.SequenceStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FizzBuzzServiceTest {

    @Mock
    private SequenceGenerator sequenceGenerator;

    @Mock
    private FizzBuzzEvaluatorStrategy fizzBuzzEvaluatorStrategy;

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzService;

    @Test
    public void testStartGameAndFetchResultsForV1() {

        FizzBuzzInputRequest fizzBuzzInputRequest = FizzBuzzInputRequest.builder().gameVersion("V1")
                .startLimit(1).endLimit(4).sequenceStrategy(SequenceStrategy.SIMPLE).build();
        when(fizzBuzzEvaluatorStrategy.fromGameVersion(eq("V1"))).thenReturn(Evaluator.FizzBuzzGameEvaluatorsV1);
        when(sequenceGenerator.getSequence(eq(fizzBuzzInputRequest))).thenReturn(Stream.of(1,2,3,4));

        FizzBuzzGameResult fizzBuzzGameResult = fizzBuzzService.startGameAndFetchResults(fizzBuzzInputRequest);
        Assertions.assertEquals(4, fizzBuzzGameResult.getFizzBuzzResults().size());
        Assertions.assertEquals(SequenceStrategy.SIMPLE, fizzBuzzGameResult.getSequenceStrategy());
        Assertions.assertEquals("V1", fizzBuzzGameResult.getGameVersion());
        verify(sequenceGenerator).getSequence(fizzBuzzInputRequest);
    }

    @Test
    public void test() throws JsonProcessingException {

        FizzBuzzInputRequest fizzBuzzInputRequest = FizzBuzzInputRequest.builder().gameVersion("V1")
                .startLimit(1).endLimit(4).sequenceStrategy(SequenceStrategy.SIMPLE).build();
        ObjectMapper mapper = new ObjectMapper();
        mapper
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        String serialized = mapper.writeValueAsString(fizzBuzzInputRequest);
        System.out.println(serialized);
    }
}
