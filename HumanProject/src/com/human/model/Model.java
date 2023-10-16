package com.human.model;

import java.util.HashMap;

public class Model {
	private HashMap<String, Object> hashmap=new HashMap<String, Object>(); 
	public void setAttribute(String key, Object value) {
		hashmap.put(key, value);
	}
	public Object getAttribute(String key) {
		return hashmap.get(key);
	}
	public void removeAttribute(String key) {
		hashmap.remove(key);
	}
}
