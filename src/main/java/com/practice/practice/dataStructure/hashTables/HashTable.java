package com.practice.practice.dataStructure.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import com.practice.practice.dataStructure.hashTables.KeyValue;

/*Program to implement Hash Table concept*/

public class HashTable {

	// create an array that will hold elements of type ArrayList<KeyValue>.
	// ArrayList<KeyValue> means the ArrayList holds Objects of type - keyValue
	// as its element

	ArrayList<KeyValue>[] data;
	int currentLength;
	

	
	//Initiate parameterized constructor with hashtable size as parameter
	public HashTable(int size) {
		data = new ArrayList[size];
		currentLength = 0;
	}

	//_hash(key) function, to generate dynamic address for the keys
	private int _hash(String key) {

		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			//The codePointAt() method returns the value of character at the index.
			hash = (hash + key.codePointAt(i) * i) % data.length;
		}

		return hash;
	}

	//set(key, value) function, to set the value of key/value pair in hashtable
	public void set(String key, int value) {
		HashTable hashTable = new HashTable(10);

		int address = hashTable._hash(key);
		//to verify and implement the solution if Collition occurs in HashTable
		if (data[address] == null) {
			ArrayList<KeyValue> arrayAtAddress = new ArrayList<>();
			data[address] = arrayAtAddress;
			currentLength++;
		}

		KeyValue pair = new KeyValue(key, value);
		data[address].add(pair);
	}

	//get(key, value) function, to get the value of key/value pair in hashtable
	public Integer get(String key) {
		HashTable hashTable = new HashTable(10);
		int address = hashTable._hash(key);
		ArrayList<KeyValue> bucket = data[address];
		if (bucket != null) {
			for (KeyValue keyValue : bucket) {
				if (keyValue.getKey().equals(key)) {
					return keyValue.getValue();
				}
			}
		}

		return null;

	}

	//keys() function, to return list of keys
	public String[] keys() {
		ArrayList<KeyValue>[] bucket = data;
		String[] keysArray = new String[currentLength];
		int count = 0;
		for (ArrayList<KeyValue> keyValues : bucket) {
			if (keyValues != null) {
				keysArray[count] = keyValues.get(0).getKey();
				count++;
			}
		}
		return keysArray;
	}

	public static void main(String[] args) {

		HashTable hashTable = new HashTable(50);
		hashTable.set("grapes", 1200);
		hashTable.set("apple", 1500);
		System.out.println("value for key grapes: " + hashTable.get("grapes"));
		System.out.println("value for key apple: " + hashTable.get("apple"));
		System.out.println("list of keys: " + Arrays.toString(hashTable.keys()));

	}

}
