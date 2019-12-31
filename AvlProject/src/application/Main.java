package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		AVLTree avlTree = new AVLTree();
//		File file = new File("D:\\Programming\\Files\\AVl.txt");
//		Scanner scanner = new Scanner(file);
//
//		while (scanner.hasNextInt()) {
//
//			int input = scanner.nextInt();
//			avlTree.insert(input);
//			System.out.println("Tree Balance: " + avlTree.getRootBalance());
//			avlTree.inorderTraversal();
//			avlTree.display();
//
//		}

		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out
					.println("***************************************************\nEnter:\n1)Intert\n2)Delete\n3)Exit");
			int input = scanner.nextInt();
			if (input == 1) {
				System.out.print("\n\nEnter the node that you wanna insert:  ");
				int addMe = scanner.nextInt();
				avlTree.insert(addMe);
				System.out.println("\nTree Balance: " + avlTree.getRootBalance());
				System.out.println("Size of the tree :  " + avlTree.getSize());
				System.out.println("\nNumber of LL Rotation: " + avlTree.getNumber_of_LL_rotation());
				System.out.println("Number of RR Rotation: " + avlTree.getNumber_of_RR_rotation());
				System.out.println("Number of RL Rotation: " + avlTree.getNumber_of_RL_rotation());
				System.out.println("Number of LR Rotation: " + avlTree.getNumber_of_LR_rotation());
				System.out.print("\nInorder Traversal: ");

				if (!avlTree.isEmpty()) {
					avlTree.inorderTraversal();
					System.out.println("\n\n");

					avlTree.display();
//					avlTree.print();
				}

				System.out.println("\n\n\n");

			} else if (input == 2) {
				System.out.print("\n\nEnter the node that you wanna delete:  ");
				int deleteMe = scanner.nextInt();
				avlTree.delete(deleteMe);
				System.out.println("\nTree Balance: " + avlTree.getRootBalance());
				System.out.println("Size of the tree :  " + avlTree.getSize());
				System.out.println("\nNumber of LL Rotation: " + avlTree.getNumber_of_LL_rotation());
				System.out.println("Number of RR Rotation: " + avlTree.getNumber_of_RR_rotation());
				System.out.println("Number of RL Rotation: " + avlTree.getNumber_of_RL_rotation());
				System.out.println("Number of LR Rotation: " + avlTree.getNumber_of_LR_rotation());
				System.out.print("\nInorder Traversal: ");

				if (!avlTree.isEmpty()) {
					avlTree.inorderTraversal();
					System.out.println("\n\n");

//					avlTree.print();
					avlTree.display();
				}

			} else if (input == 3) {
				break;
			} else
				continue;

		}

		scanner.close();

	}

}
