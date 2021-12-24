package com.practice.practice.dataStructure.hashTables;


//KeyValue class to create key object or value object for Hash table
public class KeyValue {

	private String key;
    private int value;

    public KeyValue(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
	
}
