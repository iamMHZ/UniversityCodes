package MyLinkList;

public class Main {

	public static void main(String[] args) {

		LinkList linkList = new LinkList();

		linkList.addLast(new String("Arash"));
		linkList.addLast(new String("SAWdegh1"));
		linkList.addLast(new String("SAWdegh2"));
		linkList.addLast(new String("MHZ"));

		linkList.addLast("mohamamd hossein ziaadini");

		linkList.addNext("Love", "Arash");

		linkList.Print();

	}
}