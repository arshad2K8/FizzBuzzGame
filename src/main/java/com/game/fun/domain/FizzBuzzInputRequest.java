package com.game.fun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.game.fun.service.sequence.SequenceStrategy;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FizzBuzzInputRequest {
    Integer startLimit = 1;
    Integer endLimit = 100;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty
    SequenceStrategy sequenceStrategy = SequenceStrategy.SIMPLE;
    String gameVersion = "V1";
}
