package org.example.message.queue;

public class Message {
    String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
