package pl.zebek.spring.boot.springbootws.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldWs {

    @Value("${name.value}")
    private String name;

    @GetMapping("/")
    public String hello(){
        return String.format("Hello %s!", name);
    }
}
