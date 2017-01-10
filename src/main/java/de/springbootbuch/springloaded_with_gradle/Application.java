package de.springbootbuch.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    @RestController
    @RequestMapping("/hello")
    public static class HelloWorldController {
        private final MessageGenerator messageGenerator;
        
        public HelloWorldController(final MessageGenerator messageGenerator) {
            this.messageGenerator = messageGenerator;
        }
        
        @GetMapping
        public String helloWorld(@RequestParam final String name) {
            return this.messageGenerator.getMessage(name);
        }
    }
    
    @Service
    public static class MessageGenerator {
        public String getMessage(final String name) {
            return "Hello, " + name + ". Change me as you want.\n";
        }
    }
    

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}