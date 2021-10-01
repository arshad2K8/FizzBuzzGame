package com.game.fun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.game.fun.service.sequence.SequenceStrategy;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FizzBuzzGameResult {
    List<FizzBuzzResult> fizzBuzzResults;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    SequenceStrategy sequenceStrategy;

    String gameVersion;
}
