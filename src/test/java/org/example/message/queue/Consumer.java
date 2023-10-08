package org.example.message.queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consumer {
    String name;
    int offset;

    Topic topic;

    public Consumer(String name) {
        this.name = name;
        this.offset = 0;
    }

    public void push(Message message) {
        System.out.println(name + "  Consumer  Received : " + message);
    }





    public void incrementOffset() {
        this.offset += 1;
    }
}
