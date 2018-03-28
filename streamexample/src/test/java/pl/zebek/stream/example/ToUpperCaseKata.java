package pl.zebek.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
public class ToUpperCaseKata {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = List.of("My", "name", "is", "John", "Doe");
        List<String> expected = List.of("MY", "NAME", "IS", "JOHN", "DOE");

        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

    private List<String> transform(List<String> collection) {
        return collection.stream().map(String::toUpperCase).collect(Collectors.toList());

    }

}