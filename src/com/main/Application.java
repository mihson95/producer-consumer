package com.main;

import com.classes.ConsumerImpl;
import com.classes.ProducerImpl;

public class Application {

	public static void main(String[] args) {
		ConsumerImpl consumerImpl = new ConsumerImpl(1);
		ConsumerImpl consumerImpl2 = new ConsumerImpl(2);
		ProducerImpl producerImpl = new ProducerImpl();
		producerImpl.register(consumerImpl);
		producerImpl.register(consumerImpl2);
		producerImpl.sendMessagesToConsumers();
		producerImpl.deregister(consumerImpl2);
		ConsumerImpl consumerImpl3 = new ConsumerImpl(3);
		producerImpl.register(consumerImpl3);
		producerImpl.sendMessagesToConsumers();
		producerImpl.deregister(consumerImpl);
		producerImpl.deregister(consumerImpl3);
		producerImpl.sendMessagesToConsumers();
	}

}
