package edu.festu.ivakuznetsov.spring.kafka.sample.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import edu.festu.ivakuznetsov.spring.kafka.sample.model.Greeting;

@Service
public class KafkaService {

    private final KafkaTemplate<String, Greeting> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, Greeting> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Greeting message) {
        CompletableFuture<SendResult<String, Greeting>> future = kafkaTemplate.
            send("avia1", message);
        
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message + 
                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + 
                    message + "] due to : " + ex.getMessage());
            }
        });

   }
}
