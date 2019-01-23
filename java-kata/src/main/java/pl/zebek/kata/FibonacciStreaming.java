package pl.zebek.kata;


import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class FibonacciStreaming {

    private static class FibonacciSupplier implements IntSupplier {

        int current = 1;
        int previous = 0;

        @Override
        public int getAsInt() {
            int result = current;
            current = previous + current;
            previous = result;
            return result;
        }
    }



    public static IntStream generateFibonacciSequence() {
        // To be implemented: Proper implementation.
        return IntStream.generate(new FibonacciSupplier());
    }
}
