package org.example;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MessagePackExampleTest {

    private final MessagePackExample messagePackExample = new MessagePackExample();

    @Test
    public void shouldConvertObjectToArrayOfBytes() throws IOException {
        List<String> list = List.of("Some", "text");
        Assertions.assertThat(messagePackExample.write(list)).isNotEmpty();
    }

    @Test
    public void shouldConvertArrayOfBytesToObject() throws IOException {
        List<String> list = List.of("Some", "text");
        Assertions.assertThat(messagePackExample.read(
                messagePackExample.write(list)
        ).equals(list));
    }
}
