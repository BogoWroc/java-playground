package pl.zebek.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNumbers {

    public static int findIt2(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }

    public static int findIt(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        Map<Integer, Long> result =
                list.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        return result.entrySet().stream()
                .filter(e -> e.getValue() % 2 !=0 )
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);



    }



    public static void main(String[] args) {

        int [] a = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};

        System.out.println(findIt2(a));

    }
}
