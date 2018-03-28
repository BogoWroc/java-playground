package pl.zebek.jdbi.example.pl.zebek.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
public class Kata {
    public List<Integer> findNumbers(int digitSum, int maxDigitLength) {

        return IntStream.range(0, resolveMaxRange(maxDigitLength)).filter(
                e -> Kata.isNumberHasProperDigitSum(digitSum, e)
        ).sorted().boxed().collect(Collectors.toList());

    }

    public static boolean isNumberHasProperDigitSum(int expectedDigitSum, int num) {
        return calculateDigitSum(num) == expectedDigitSum;
    }

    private static int calculateDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    private int resolveMaxRange(int maxDigitLength) {
        return (int) Math.pow(10, maxDigitLength) - 1;
    }

}
