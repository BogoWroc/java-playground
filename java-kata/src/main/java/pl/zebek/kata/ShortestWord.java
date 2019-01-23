package pl.zebek.kata;

import java.util.Arrays;
import java.util.stream.Stream;

public class ShortestWord {

    public static void main(String[] args) {
        String s = "bitcoin take over the world maybe who knows perhaps";
        String[] split = s.split(" ");

        System.out.println(Arrays.stream(split).mapToInt(it -> it.length()).min().getAsInt());
    }
}
