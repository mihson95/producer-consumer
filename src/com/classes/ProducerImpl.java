package com.classes;

import java.util.ArrayList;
import java.util.List;

import com.interfaces.Consumer;
import com.interfaces.Producer;

public class ProducerImpl implements Producer{
	
	List<Consumer> allConsumers;
	
	public ProducerImpl() {
		this.allConsumers = new ArrayList<Consumer>();
	}
	
	@Override
	public void register(Consumer consumer) {
		this.allConsumers.add(consumer);
		System.out.println(consumer.getConsumerId()+" is registered.");
	}

	@Override
	public void deregister(Consumer consumer) {
		this.allConsumers.remove(consumer);
		System.out.println(consumer.getConsumerId()+" is deregistered.");
	}
	
	public void sendMessagesToConsumers() {
		int count = 0;
		for(Consumer consumer : allConsumers) {
			consumer.consumeMessage();
			count++;
		}
		System.out.println(count+" Messages successfully sent.");
	}
	

}
