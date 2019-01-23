package pl.zebek.kata;

import java.util.Arrays;
import java.util.stream.Stream;

public class TheHighestProfitWins {
    public static void main(String[] args) {
        int [] arr =  new int[]{1,2,3,4,5};
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int [] retVal = new int[]{min,max};
    }
}
