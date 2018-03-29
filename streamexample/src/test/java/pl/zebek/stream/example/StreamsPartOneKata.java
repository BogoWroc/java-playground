package pl.zebek.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 29.03.18.
 */
public class StreamsPartOneKata {

    private List<String> words = List.of("hi", "hello", "world");

    private static void displayFormattedString(String text) {
        System.out.println(String.format("  %s", text));
    }

    @Test
    public void firstKata() {
        /*
         * Loop down the words and print each on a separate line, with two spaces in front of each word.
         Don’t use map.
         */
        words.forEach(StreamsPartOneKata::displayFormattedString);
    }

    @Test
    public void secondKata() {
        /*
         * In the previous exercise, we produced transformed lists like this:
         • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
         • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
         • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
         Produce the same lists as above, but this time use streams and the builtin “map” method.
         */

        assertThat(words.stream().map(e -> e + "!").collect(Collectors.toList())).contains(
                "hi!",
                "hello!",
                "world!"
        );

        assertThat(words.stream().map(e -> e.replace("i", "eye")).collect(Collectors.toList())).contains(
                "heye",
                "hello",
                "world"
        );

        assertThat(words.stream().map(String::toUpperCase).collect(Collectors.toList())).contains(
                "HI",
                "HELLO",
                "WORLD"
        );

    }


    @Test
    public void thirdKata() {
        /*
         * In the previous exercise, we produced filtered lists like this:
         • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
         • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
         • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
         Produce the same lists as above, but this time use “filter”.
         */

        assertThat(words.stream().filter(e -> e.length() < 4)).contains("hi");
        assertThat(words.stream().filter(e -> e.contains("b"))).isEmpty();
        assertThat(words.stream().filter(e -> e.length() % 2 == 0)).contains("hi");
    }

    @Test
    public void fourthKata() {
        /*
         * Turn the strings into uppercase, keep only the ones that are shorter than 6 characters, of what is
         remaining, keep only the ones that contain “E”, and print the first result.
         */

        List<String> list = words.stream().map(String::toUpperCase).filter(e -> e.length() < 6).
                filter(e -> e.contains("E")).collect(Collectors.toList());

        assertThat(list).containsOnly("HELLO");
    }

}
