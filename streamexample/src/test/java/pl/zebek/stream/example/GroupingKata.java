package pl.zebek.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
    /*
Group people by nationality
 */
public class GroupingKata {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = List.of(sara, eva, viktor);
        Map<String, List<Person>> result = groupByNationality(collection);
        assertThat(result.get("Norwegian")).hasSameElementsAs(List.of(sara, eva));
        assertThat(result.get("Serbian")).hasSameElementsAs(List.of(viktor));
    }

    private Map<String, List<Person>> groupByNationality(List<Person> collection) {
        return collection.stream().collect(Collectors.groupingBy(p -> p.getNationality()));
    }

}

