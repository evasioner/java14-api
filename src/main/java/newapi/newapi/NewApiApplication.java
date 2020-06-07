package newapi.newapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.el.BeanNameResolver;

@SpringBootApplication
public class NewApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewApiApplication.class, args);
    }

    private static ConfigurableApplicationContext configurableApplicationContext;

    public static ApplicationContext getApplicationContext() {
        return NewApiApplication.configurableApplicationContext;
    }
}
