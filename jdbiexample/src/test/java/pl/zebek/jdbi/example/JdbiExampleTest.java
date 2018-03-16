package pl.zebek.jdbi.example;

import org.jdbi.v3.core.Jdbi;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bogumil Zebek on 16.03.18.
 */
public class JdbiExampleTest {

    @Test
    public void should_connect_to_h2_db_and_feth_data() throws ClassNotFoundException {

//        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test"); // (H2 in-memory database)

        Properties properties = new Properties();
        properties.setProperty("username", "sa");
        properties.setProperty("password", "");
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem:testDB", properties);

        List<User> users = jdbi.withHandle(handle -> {
            handle.execute("CREATE TABLE user (id INTEGER PRIMARY KEY, name VARCHAR(30))");

            // Inline positional parameters
            handle.execute("INSERT INTO user(id, name) VALUES (?, ?)", 0, "Alice");

            // Positional parameters
            handle.createUpdate("INSERT INTO user(id, name) VALUES (?, ?)")
                    .bind(0, 1) // 0-based parameter indexes
                    .bind(1, "Bob")
                    .execute();

            // Named parameters
            handle.createUpdate("INSERT INTO user(id, name) VALUES (:id, :name)")
                    .bind("id", 2)
                    .bind("name", "Clarice")
                    .execute();

            // Named parameters from bean properties
            handle.createUpdate("INSERT INTO user(id, name) VALUES (:id, :name)")
                    .bindBean(new User(3, "David"))
                    .execute();

            // Easy mapping to any type
            return handle.createQuery("SELECT * FROM user ORDER BY name")
                    .mapToBean(User.class)
                    .list();
        });

        assertThat(users).containsExactly(
                new User(0, "Alice"),
                new User(1, "Bob"),
                new User(2, "Clarice"),
                new User(3, "David"));
    }
}
