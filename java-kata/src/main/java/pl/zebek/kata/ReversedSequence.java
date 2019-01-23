package pl.zebek.kata;

import java.util.Collections;
import java.util.stream.IntStream;

public class ReversedSequence {

    public static void main(String[] args) {
        int n = 5;
        int[] ints = IntStream.rangeClosed(0,n).boxed().sorted(Collections.reverseOrder()).mapToInt(it -> it).toArray();
        System.out.println(ints);
    }
}
