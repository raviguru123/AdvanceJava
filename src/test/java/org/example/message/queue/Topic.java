package org.example.message.queue;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    String name;
    List<Message> messageList;
    List<Consumer> consumerList;

    public Topic(String name) {
        this.name = name;
        this.messageList = new ArrayList<>();
        this.consumerList = new ArrayList<>();
    }

    public void sendMessage(Message message) {
        this.messageList.add(message);
        for (Consumer consumer : consumerList) {
            poll(consumer);
        }
    }

    public void subscribe(Consumer consumer) {
        consumerList.add(consumer);
    }

    public void poll(Consumer consumer) {
        int offset = consumer.getOffset();
        if (offset >= 0 && offset < this.messageList.size()) {
            int i = offset;
            consumer.incrementOffset();
            consumer.push(this.messageList.get(i));
        }
    }

}
