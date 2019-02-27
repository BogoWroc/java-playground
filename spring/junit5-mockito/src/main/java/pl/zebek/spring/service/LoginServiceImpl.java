package pl.zebek.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private Hello hello;

    @Override
    public String login(String userName) {
        return hello.sayHello(userName);
    }
}
