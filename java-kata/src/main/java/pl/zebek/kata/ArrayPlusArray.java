package pl.zebek.kata;

import java.util.stream.IntStream;

public class ArrayPlusArray {
    public static void main(String[] args) {
        System.out.println(arrayPlusArray(new int[]{1,2,3}, new int[]{4,5,6}));
    }

    private static int arrayPlusArray(int[] arr1, int[] arr2) {
        return IntStream.of(arr1).sum() + IntStream.of(arr2).sum();
    }
}
