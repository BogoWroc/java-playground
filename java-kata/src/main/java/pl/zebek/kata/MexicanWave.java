package pl.zebek.kata;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MexicanWave {

    private static class MexicanWaveWordGenerator implements Supplier<String>{

        private final String word;
        private int index=0;

        private MexicanWaveWordGenerator(String word) {
            this.word = word;
        }

        @Override
        public String get() {
            // Convert String to char array.
            char[] arr = this.word.toCharArray();
            // Modify first element in array.
            arr[this.index] = Character.toUpperCase(arr[this.index]);
            this.index++;
            return new String(arr);
        }
    }
    public static void main(String [] str) {
        // Your code here

        String [] list = Stream.generate(new MexicanWaveWordGenerator("two words"))
                .limit("two words".length())
                .filter(it -> !it.equals("two words"))
                .toArray(String[]::new);

    }
}
