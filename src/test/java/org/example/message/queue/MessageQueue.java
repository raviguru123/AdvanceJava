package org.example.message.queue;

import java.util.HashMap;
import java.util.Map;

public class MessageQueue {
    String name;
    Map<String, Producer> producerMap;
    Map<String, Consumer> consumerMap;
    Map<String, Topic> topicMap;

    public MessageQueue(String name) {
        this.name = name;
        this.producerMap = new HashMap<>();
        this.topicMap = new HashMap<>();
        this.consumerMap = new HashMap<>();
    }

    public void createProducer(String name) {
        Producer producer = new Producer(name);
        this.producerMap.put(producer.getName(), producer);
    }

    public void createConsumer(String name) {
        Consumer consumer = new Consumer(name);
        this.consumerMap.put(consumer.getName(), consumer);
    }

    public void createTopic(String name) {
        Topic topic = new Topic(name);
        this.topicMap.put(topic.getName(), topic);
    }

    public void subscribeTopic(String topicName, String consumerName) throws Exception {
        if (!this.topicMap.containsKey(topicName) || !this.consumerMap.containsKey(consumerName)) {
            throw new Exception("Invalid topic name or consumer name");
        }

        Consumer consumer = this.consumerMap.get(consumerName);
        Topic topic = this.topicMap.get(topicName);
        Consumer consume2 = new Consumer(consumer.getName());
        topic.subscribe(consume2);
        consume2.setTopic(topic);
    }

    public void publishMessage(String producerName, String topicName, String message) {
        Topic topic = this.topicMap.get(topicName);
        topic.sendMessage(new Message(message));
    }


}
