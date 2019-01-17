package pl.zebek.kata;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSheep {

    public static String countingSheep(int num) {
        return IntStream.rangeClosed(1, num).mapToObj(
                it -> it + " sheep..."
        ).collect(
                Collectors.joining()
        );

    }
}
