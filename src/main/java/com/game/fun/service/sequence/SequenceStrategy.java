package com.game.fun.service.sequence;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public enum SequenceStrategy {

    SIMPLE {
        @Override
        public Stream<Integer> getSequenceStream(Integer startLimit, Integer endLimit) {
            return IntStream.rangeClosed(startLimit, endLimit).boxed();
        }
    };

    public abstract Stream<Integer> getSequenceStream(Integer startLimit, Integer endLimit);

    public static SequenceStrategy fromType(String type) {
        for (SequenceStrategy value : values()) {
            if (value.name().equalsIgnoreCase(type)) {
                return value;
            }
        }
        return SIMPLE;
    }

}
