package edu.festu.ivakuznetsov.spring.kafka.sample.model;

public class Greeting {
    Integer id;
    String text;
    public Greeting(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
    public Greeting() {
        text = "greeting!";
        id = 0;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
