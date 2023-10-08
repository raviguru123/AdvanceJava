The queue should be in-memory and should not require access to the file system/data store.

There can be multiple topics in the queue.

A message (type = String ) can be published on a topic by a producer/publisher and consumers/subscribers can subscribe to the topic to receive the messages.

There can be multiple producers and consumers.

A producer can publish to multiple topics.

A consumer can listen to multiple topics.

The consumer should print "<consumer_id> received <message>" on receiving the message.





Input/Output Format:

You DO NOT need to provide input from the command-line.

Create 2 topics: Topic1 and Topic2.

Create 2 producers: Producer1 and Producer2.

Create 5 consumers: Consumer1, Consumer2, Consumer3, Consumer4, and Consumer5.

Make all 5 consumers subscribe to Topic1.

Make consumers 1, 3, and 4 subscribe to Topic2.

Make producer1 publish message "Message 1" to Topic1

Make producer1 publish message "Message 2" to Topic1

Make producer2 publish message "Message 3" to Topic1

Make producer1 publish message "Message 4" to Topic2

Make producer2 publish message "Message 5" to Topic2



Consumer
int offeset



Producer


Queue
List<Topics>


Topic
List<Consumer>
List<Message> messageList.get

 	poll(Cosumer,offset) {
 		Message message = 
 	}



Message





MessageQueue

	Map<Name, Topic>
	Map<prodName, Producer>


	publish(Producer, topic, message)
		topic.send(message)

	createTopic(name)

	deleteTopic(name)

	suscribe(ConsumerName, topicName)
	




