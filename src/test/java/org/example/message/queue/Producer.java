package org.example.message.queue;

import lombok.Getter;

@Getter
public class Producer {
    String name;

    public Producer(String name) {
        this.name = name;
    }
}
