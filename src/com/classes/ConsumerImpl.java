package com.classes;

import com.interfaces.Consumer;

public class ConsumerImpl implements Consumer {

	private final int consumerId;

	public ConsumerImpl(int consumerId) {
		this.consumerId = consumerId;
	}

	@Override
	public void consumeMessage(String message) {
		System.out.println("Message Received by consumerId=" + consumerId + ": " + message);
	}

	@Override
	public int getConsumerId() {
		return this.consumerId;
	}
}
