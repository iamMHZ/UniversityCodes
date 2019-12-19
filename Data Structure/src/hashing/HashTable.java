package hashing;

public class HashTable {

	private Person[] hashArray;

	public HashTable() {
		hashArray = new Person[10];

	}

	public void put(Person p) {
		int key = generateKey(p.getName());

		if (hashArray[key] == null) {
			hashArray[key] = p;
			System.out.println("DONE");
		} else {
			System.out.println("this index is alredy taken");
		}

	}

	private int generateKey(String key) {
		return key.length() % hashArray.length;
	}

	public void get(String personName) {
		int key = generateKey(personName);

		if (hashArray[key] != null)
			System.out.println(hashArray[key]);
		else
			System.out.println("there is nobody with this name in the hashTable");
	}

	public Person[] getHashTable() {
		return hashArray;
	}

	public void setHashTable(Person[] hashTable) {
		this.hashArray = hashTable;
	}

}
