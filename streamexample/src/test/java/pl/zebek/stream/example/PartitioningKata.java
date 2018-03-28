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
Partition adults and kids
 */
public class PartitioningKata {


    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = List.of(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults(collection);
        assertThat(result.get(true)).hasSameElementsAs(List.of(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(List.of(sara));
    }

    private Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
        return collection.stream().collect(Collectors.partitioningBy(e -> e.getAge() >= 18));
    }

}