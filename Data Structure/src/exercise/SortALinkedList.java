package exercise;

import MyLinkList.LinkList;
import MyLinkList.Node;

public class SortALinkedList {

	public static void sort(LinkList linkList) {
		Node temp1 = linkList.getHead();
		Node temp2;

		while (temp1 != null) {
			temp2 = temp1;

			while (temp2 != null) {
				if (temp1.getData().length() < temp2.getData().length()) {
					String temp = temp1.getData();
					temp1.setData(temp2.getData());
					temp2.setData(temp);
				}

				temp2 = temp2.getNext();
			}

			temp1 = temp1.getNext();
		}

	}

	public static void main(String[] args) {
		
		
		LinkList linkList = new LinkList();
		linkList.addToFront("111");
		linkList.addToFront("1111");
		linkList.addToFront("1");
		linkList.addToFront("11");
		
		linkList.Print();
		
		sort(linkList);
		
		System.out.println();
		linkList.Print();

	}

}
