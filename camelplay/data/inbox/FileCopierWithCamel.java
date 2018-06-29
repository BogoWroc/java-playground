package pl.zebek.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Bogumil Zebek on 6/29/18.
 */
public class FileCopierWithCamel {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }

}
