package pl.zebek.spring.service;

import org.springframework.stereotype.Component;


@Component
public class HelloImpl implements Hello {

    @Override
    public String sayHello(String name) {
        return String.format("Hi, %s!", name);
    }
}
