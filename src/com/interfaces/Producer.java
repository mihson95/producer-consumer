package com.interfaces;

public interface Producer {

	boolean register(Consumer consumer);
	boolean deregister(Consumer consumer);
	int sendMessageToConsumers(String message);
}
