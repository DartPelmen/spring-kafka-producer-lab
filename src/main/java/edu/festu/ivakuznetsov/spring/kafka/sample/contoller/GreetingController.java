package edu.festu.ivakuznetsov.spring.kafka.sample.contoller;

import org.springframework.web.bind.annotation.RestController;

import edu.festu.ivakuznetsov.spring.kafka.sample.model.Greeting;
import edu.festu.ivakuznetsov.spring.kafka.sample.service.KafkaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class GreetingController {
  
    
    private final KafkaService kafkaService;

    public GreetingController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }
    @GetMapping("/")
    public Greeting getGreeting() {
        return new Greeting();
    }
    @PostMapping("/")
    public Greeting sendToKafka(@RequestBody Greeting entity) {
        System.out.println("CONTROLLER: GOT MESSAGE");
        System.out.println(entity.getText());
        kafkaService.sendMessage(entity);
        return entity;
    }
}
