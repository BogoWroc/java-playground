package pl.zebek.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class LoginServiceMockTest {

    @Mock
    private Hello hello;

    @InjectMocks // auto inject hello
    private LoginService loginService = new LoginServiceImpl();

    @BeforeEach
    void setMockOutput() {
        when(hello.sayHello("John")).thenReturn("Hello Mockito From Repository");
    }

    @DisplayName("Test Mock loginService + hello")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Repository", loginService.login("John"));
    }
}
