package pl.zebek.spring.boot.springbootws;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.zebek.spring.boot.springbootws.beans.HelloWorldBean;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorldBean helloWorldBean = applicationContext.getBean("myHelloWorldBean", HelloWorldBean.class);
        System.out.println(helloWorldBean.sayHello("Bob"));

        applicationContext.close();


    }
}
