package pl.zebek.kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataReverse {

    public static int[] dataReverse(int[] data) {

        List<int[]> list = splitArray(data);


        List<int[]> invertedList = invertArray(list);

        IntStream intStream = invertedList.stream().flatMapToInt(x -> Arrays.stream(x));
        List<Integer> collect = intStream.boxed().collect(Collectors.toList());


        return collect.stream().mapToInt(i->i).toArray();
    }

    private static List<int []> invertArray(List<int[]> list) {
        List<int[]> invertedList = new ArrayList();
        for (int i = list.size() - 1; i >= 0; i--) {
                invertedList.add(list.get(i));
        }

        return invertedList;
    }

    private static List<int[]> splitArray(int[] data) {
        List<int[]> list = new ArrayList<>();

        int chunk = 8;
        for(int i=0;i<data.length;i+=chunk){
            list.add(Arrays.copyOfRange(data, i, Math.min(data.length,i+chunk)));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dataReverse(new int [] {0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1})));
    }
}
