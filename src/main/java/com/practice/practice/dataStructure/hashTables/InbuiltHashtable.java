package com.practice.practice.dataStructure.hashTables;

import java.util.Hashtable;
import java.util.Map;

public class InbuiltHashtable {

	public static void main(String[] args) {

		// We can also use HashMap or HashSet
		Map<String, String> phoneBook = new Hashtable<String, String>();

		// putting keys:values in hashtable phonebook
		phoneBook.put("Anupam", "8506078320");
		phoneBook.put("Chris", "445454545");
		phoneBook.put("Morris", "4548623233");
		phoneBook.put("Mary", "865656223");

		System.out.println("Phonebook: " + phoneBook);
		// accessing values using keys
		System.out.println("Anupam's phone number: " + phoneBook.get("Anupam"));
		// deleting entries using keys
		System.out.println("Remove Morris: " + phoneBook.remove("Morris"));
		// phonebook after removing Morris
		System.out.println("Phonebook: " + phoneBook);

	}

}
