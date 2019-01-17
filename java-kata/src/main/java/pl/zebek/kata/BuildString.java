package pl.zebek.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildString {

    public static String formatWords(String[] words) {
        // Do the things...
        if (words == null)
            return "";

        List<String> strings = Arrays.asList(words);
        strings = strings.stream().filter(it -> !it.isEmpty()).collect(Collectors.toList());
        if (strings.size() == 1) {
            return strings.get(0);
        }
        if (strings.size() == 2) {
            return strings.stream().collect(Collectors.joining(" and "));
        }
        if (strings.size() > 2) {
            List<String> subList = strings.subList(0, strings.size() - 1);
            return subList.stream().collect(Collectors.joining(", ")) + " and " + strings.get(strings.size() - 1);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(formatWords(new String[]{"one", "two", "three", "four"}));
        System.out.println(formatWords(new String[]{"one"}));
        System.out.println(formatWords(new String[]{"one", "", "three"}));
        System.out.println(formatWords(new String[]{"", "", "three"}));
        System.out.println(formatWords(new String[]{"one", "two", ""}));
        System.out.println(formatWords(new String[]{}));
        System.out.println(formatWords(null));
        System.out.println(formatWords(new String[]{""}));
    }
}
