package exercise;

import MyLinkList.LinkList;
import MyLinkList.Node;

public class LinkedListReverser {

	// using linklist class in package MyLinkedlist:
	public static void reverse(LinkList LinkedListlist) {

		Node head = LinkedListlist.getHead();
		Node current = head;
		Node prev = null;
		Node next = head;

		while (current != null) {

			next = next.getNext();
			current.setNext(prev);
			prev = current;

			current = next;

		}

		LinkedListlist.setHead(prev);
	}

	public static void JustPrintingReversly(Node start) {

		if (start == null)
			return;

		JustPrintingReversly(start.getNext());
		System.out.print(start.getData());
		
	}

	public static void main(String[] args) {
		LinkList linkList = new LinkList();

		linkList.addLast("1");
		linkList.addLast("2");
		linkList.addLast("3");
		linkList.addLast("4");

		linkList.Print();

		reverse(linkList);
		System.out.println();
		linkList.Print();
//
//		System.out.println("Using Just Printing Method:   ");
//		JustPrintingReversly(linkList.getHead());
	}

}
