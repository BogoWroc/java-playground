package pl.zebek.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
/*
Filter collection so that only elements with less then 4 characters are returned.
 */
public class FilterCollectionKata {

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = List.of("My", "name", "is", "John", "Doe");
        List<String> expected = List.of("My", "is", "Doe");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

    private List<String> transform(List<String> collection) {
        return collection.stream().filter(e -> e.length() < 4).collect(Collectors.toList());
    }

}
