package com.classes;

import com.interfaces.Consumer;

public class ConsumerImpl implements Consumer{
	
	int consumerId;
	
	public ConsumerImpl(int consumerId) {
		this.consumerId = consumerId;
	}
	
	@Override
	public void consumeMessage() {
		System.out.println("Message Received by consumerId="+consumerId);
	}

	@Override
	public int getConsumerId() {
		return this.consumerId;
	}


}
