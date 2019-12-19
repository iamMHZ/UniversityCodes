package hashing;

public class Main {

	public static void main(String[] args) {

		HashTable hashTable = new HashTable();
		Person[] persons = { new Person("Arash", 4), new Person("MHZ", 20), new Person("Abolfazl", 13) };

		hashTable.put(persons[1]);
		// a person with the repetitive name.length that causes collision:
		hashTable.put(persons[1]);

		hashTable.put(persons[0]);
		hashTable.put(persons[2]);

		hashTable.get("mhz");
		hashTable.get("MHZ");
		hashTable.get("bbbbbbbbb");
		// it causes collision:
		hashTable.get("123");

	}

}
