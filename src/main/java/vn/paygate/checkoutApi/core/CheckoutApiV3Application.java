package vn.paygate.checkoutApi.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckoutApiV3Application {

    public static void main(String[] args) {
//        System.setProperty("spring.profiles.active", System.getenv("SPRING_PROFILES_ACTIVE"));
        System.out.println("Active Profile: " + System.getProperty("spring.profiles.active"));
        SpringApplication.run(CheckoutApiV3Application.class, args);
    }

}
