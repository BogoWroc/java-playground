package pl.zebek.kata;

import java.util.Arrays;


public class InvertValues {

    public static void main(String[] args) {
        int[] input = new int[] {-1,-2,-3,-4,-5};

        int [] i = Arrays.stream(input).boxed().mapToInt(it -> -it).toArray();
        System.out.println(i);
    }
}
