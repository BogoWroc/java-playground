package pl.zebek.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Bogumil Zebek on 6/29/18.
 */
public class SpyProcessor implements Processor{

    public void process(Exchange exchange) throws Exception {

        System.out.println("Debugging point");
    }
}
