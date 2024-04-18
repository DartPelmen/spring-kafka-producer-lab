package edu.festu.ivakuznetsov.spring.kafka.sample.messaging;

public class Constants {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    static private String bootstrapAddress;
}
