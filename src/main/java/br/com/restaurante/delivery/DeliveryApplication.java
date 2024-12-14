package br.com.restaurante.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DeliveryApplication {

    public String getHomeTeste() {
        return "Delivery - API Home";
    }
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

}
