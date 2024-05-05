package com.interfaces;

public interface Producer {
	
	public void register(Consumer consumer);
	public void deregister(Consumer consumer);
}
