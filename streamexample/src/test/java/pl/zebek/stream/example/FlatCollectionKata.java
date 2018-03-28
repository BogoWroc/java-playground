package pl.zebek.stream.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
public class FlatCollectionKata {
    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = List.of(List.of("Viktor", "Farcic"), List.of("John", "Doe", "Third"));
        List<String> expected = List.of("Viktor", "Farcic", "John", "Doe", "Third");
        Assertions.assertThat(transform(collection)).hasSameElementsAs(expected);
    }

    private List<String> transform(List<List<String>> collection) {
        return collection.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
