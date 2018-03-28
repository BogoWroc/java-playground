package pl.zebek.restexample;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

public class RestTemplateTest {

    RestTemplate restTemplate = new RestTemplate();

    private static final String CUSTOMER_API = "https://api.predic8.de:443/shop/customers/";

    @Test
    public void getCustomers() {
        JsonNode jsonNode = restTemplate.getForObject(CUSTOMER_API, JsonNode.class);
        System.out.println(jsonNode);
    }

    @Test
    public void createCustomer() {
        Map<String, Object> customers = Map.of(
                "firstname", "Freddy",
                "lastname", "Meyers"
        );

        JsonNode jsonNode = restTemplate.postForObject(CUSTOMER_API, customers, JsonNode.class);
        System.out.println(jsonNode);
    }
}
