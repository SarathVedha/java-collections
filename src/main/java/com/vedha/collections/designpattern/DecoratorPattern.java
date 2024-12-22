package com.vedha.design;

import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {

    private final static Integer DEFAULT_VALUE = 2;

    public static Integer add(Integer input) {

        return Integer.sum(input, DEFAULT_VALUE);
    }

    public static Integer multiply(Integer input) {

        return Math.multiplyExact(input, DEFAULT_VALUE);
    }

    public static Integer subtract(Integer input) {

        return Math.subtractExact(input, DEFAULT_VALUE);
    }

    public static Integer divide(Integer input) {

        return Math.divideExact(input, DEFAULT_VALUE);
    }

    public static void main(String... args) {

        // flow: first Process() apply method returns same input as 10,
        // and then pass to MULTIPLY and then result,
        // pass to ADD and then ... final return the value.
        Sample sample = new Sample(DecoratorPattern::multiply, DecoratorPattern::add,
                DecoratorPattern::subtract, DecoratorPattern::divide, DecoratorPattern::add);
        System.out.println(sample.process(10));

    }
}

class Sample {

    private final Function<Integer, Integer> function;

    // Chain Of functions
    @SafeVarargs
    public Sample(Function<Integer, Integer>... functions) {

//            this.function = Stream.of(functions)
//                    .reduce(input -> input, (result, nextFunction) -> result.andThen(nextFunction));

        // reduce -> collection of data and combine into one data.
        // Function.identity() -> function that always returns its input argument.
        this.function = Stream.of(functions).reduce(Function.identity(),
                Function::andThen);
    }

    public Integer process(Integer input) {

        return function.apply(input);
    }
}
