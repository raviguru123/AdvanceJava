package org.example.message.queue;

public class Driver {
    public static void main(String [] args) throws  Exception{
        MessageQueue messageQueue = new MessageQueue("first");
        messageQueue.createTopic("Topic1");
        messageQueue.createTopic("Topic2");

        messageQueue.createProducer("Producer1");
        messageQueue.createProducer("Producer2");
        messageQueue.createProducer("Producer3");

        messageQueue.createConsumer("Consumer1");
        messageQueue.createConsumer("Consumer2");
        messageQueue.createConsumer("Consumer3");
        messageQueue.createConsumer("Consumer4");
        messageQueue.createConsumer("Consumer5");

        messageQueue.subscribeTopic("Topic1", "Consumer1");
        messageQueue.subscribeTopic("Topic1", "Consumer2");
        messageQueue.subscribeTopic("Topic1", "Consumer3");
        messageQueue.subscribeTopic("Topic1", "Consumer4");
        messageQueue.subscribeTopic("Topic1", "Consumer5");



        messageQueue.subscribeTopic("Topic2", "Consumer1");
        messageQueue.subscribeTopic("Topic2", "Consumer3");
        messageQueue.subscribeTopic("Topic2", "Consumer4");


        messageQueue.publishMessage("Producer2", "Topic2", "topic2 Message");
        System.out.println("<========== Separator ===========> ");
        System.out.println("<========== Separator ===========> ");
        messageQueue.publishMessage("Producer1", "Topic1", "topic1 Message");

        System.out.println("<========== Separator ===========> ");
        System.out.println("<========== Separator ===========> ");
        messageQueue.publishMessage("Producer2", "Topic2", "topic22 Message");

        Thread.sleep(1000);

        System.out.println("<========== Separator ===========> ");
        System.out.println("<========== Separator ===========> ");

        messageQueue.publishMessage("Producer2", "Topic1", "topic1 second  Message");

    }
}
