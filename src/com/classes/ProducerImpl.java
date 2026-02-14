package com.classes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.interfaces.Consumer;
import com.interfaces.Producer;

public class ProducerImpl implements Producer {

	private final Map<Integer, Consumer> allConsumers;

	public ProducerImpl() {
		this.allConsumers = new LinkedHashMap<Integer, Consumer>();
	}

	@Override
	public synchronized boolean register(Consumer consumer) {
		if (consumer == null) {
			throw new IllegalArgumentException("consumer cannot be null");
		}

		int consumerId = consumer.getConsumerId();
		if (allConsumers.containsKey(consumerId)) {
			System.out.println(consumerId + " is already registered.");
			return false;
		}

		this.allConsumers.put(consumerId, consumer);
		System.out.println(consumerId + " is registered.");
		return true;
	}

	@Override
	public synchronized boolean deregister(Consumer consumer) {
		if (consumer == null) {
			return false;
		}

		int consumerId = consumer.getConsumerId();
		if (this.allConsumers.remove(consumerId) != null) {
			System.out.println(consumerId + " is deregistered.");
			return true;
		}

		System.out.println(consumerId + " is not registered.");
		return false;
	}

	@Override
	public int sendMessageToConsumers(String message) {
		List<Consumer> snapshot;
		synchronized (this) {
			snapshot = new ArrayList<Consumer>(allConsumers.values());
		}

		for (Consumer consumer : snapshot) {
			consumer.consumeMessage(message);
		}
		System.out.println(snapshot.size() + " messages successfully sent.");
		return snapshot.size();
	}
}
