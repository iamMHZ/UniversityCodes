package doubly_Linked_List;

public class Main {

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		list.addToFront("MHZ");
		list.addToFront("MHZ BE the Best");

		list.addToEnd("Arash");
		list.addToEnd("Arash & ABL");

		list.addToFront("FAMILY");
		
		list.addAfter("after", "MHZ");

		
		list.addToFront("Removed");
		list.print();
		list.removeFromFront();
		list.print();
		list.addToEnd("ADDED TO END");
		list.print();
		list.removeFromEnd();
		list.print();
	}

}
