package test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(12);
		priorityQueue.add(22);
		priorityQueue.add(-12);
		priorityQueue.add(13);
		priorityQueue.add(1333);

		System.out.println(priorityQueue.remove());

	}

}
