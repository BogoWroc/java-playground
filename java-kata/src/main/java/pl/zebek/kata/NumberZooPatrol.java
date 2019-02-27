package pl.zebek.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberZooPatrol {

    public static void main(String[] args) {
        int [] arr = new int[] {1, 3, 4};
        final List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int min = IntStream.of(arr).min().getAsInt();

        int max = IntStream.of(arr).max().getAsInt();

        System.out.println(IntStream.rangeClosed(min, max).filter(it -> !l.contains(it)).findFirst().getAsInt());
    }
}
