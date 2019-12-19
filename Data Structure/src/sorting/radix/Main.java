package sorting.radix;

public class Main {

	public static void main(String[] args) {

		String[] numbers = { "55", "77", "94", "31", "57", "41", "99", "78" };

		RadixSort radixSort = new RadixSort(numbers);

		radixSort.sort();

		String[] sortedNumbers = radixSort.getSortedNumbers();
		
		for (String string : sortedNumbers) {
			
			System.out.println(string);
		}
		
	}

}
