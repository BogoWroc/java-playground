package pl.zebek.jdbi.example.pl.zebek.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
public class KataTest {

    @Test
    public void shouldReturnsDigitsWithCorrectSum_maxLengthEquals1() {

        Kata kata = new Kata();
        int maxDigitLength = 1;

        Assertions.assertThat(kata.findNumbers(0, maxDigitLength)).contains(0);
        Assertions.assertThat(kata.findNumbers(5, maxDigitLength)).contains(5);
        Assertions.assertThat(kata.findNumbers(9, maxDigitLength)).contains(9);
    }

    @Test
    public void shouldReturnsDigitsWithCorrectSum_maxLengthEquals2() {

        Kata kata = new Kata();
        int maxDigitLength = 2;

        List<Integer> numbers = kata.findNumbers(10, maxDigitLength);
        System.out.println("#### "+ numbers);
        Assertions.assertThat(numbers).contains(19, 28, 46, 55, 64, 82, 91 );

    }

    @Test
    public void should(){
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(1, 1)).isTrue();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(1, 2)).isFalse();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 0)).isFalse();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 1)).isFalse();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 19)).isTrue();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 28)).isTrue();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 91)).isTrue();
        Assertions.assertThat(Kata.isNumberHasProperDigitSum(10, 55)).isTrue();
    }
}
