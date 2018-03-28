package pl.zebek.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
/*
Return people names separated by comma
 */
public class JoiningKata {



    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = List.of(sara, viktor, eva);
        assertThat(namesToString(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }

    private String namesToString(List<Person> collection) {
        return collection.stream().map(Person::getName).collect(Collectors.joining(", ","Names: ","."));
    }

}