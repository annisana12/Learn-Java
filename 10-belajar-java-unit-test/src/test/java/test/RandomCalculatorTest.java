package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import test.resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbstractCalculatorTest {

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("test calculator random")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} of {totalRepetitions}"
    )
    public void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("test calculator random with info")
    @RepeatedTest(
            value = 10,
            name = "{displayName}"
    )
    public void testRandomRepeatInfo(Random random, TestInfo info, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());

        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test calculator with value source")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1, 2, 3, 5, 79, 11})
    public void testWithParameter(int value) {
        var result = calculator.add(value, value);
        var expected = value + value;

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 3, 5, 8);
    }

    @DisplayName("Test calculator with method source")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    public void testWithMethodSource(Integer value) {
        var result = calculator.add(value, value);
        var expected = value + value;

        Assertions.assertEquals(expected, result);
    }
}
