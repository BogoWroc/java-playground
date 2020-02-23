package pl.zebek.spring.boot.springbootws.beans;

public class HelloWorldBean {

    public String sayHello(String name){
        return String.format("Hello, %s!", name);
    }
}
