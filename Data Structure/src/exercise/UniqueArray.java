package exercise;

import java.util.ArrayList;
import java.util.List;

public class UniqueArray {

	public static List<Integer> uniqueCkecker(int[] a) {
		List<Integer> list = new ArrayList<>();

//		Arrays.stream(a).filter(( d) -> {
//			if(d>10)
//				return true;
//			
//			return false;
//		}).

		for (int i = 0; i < a.length; i++) {
			boolean flag = true;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					flag = false;
					break;
				}
			}

			if (flag == true)
				list.add(a[i]);
		}

		return list;
	}

	public static void main(String[] args) {
		int[] b = { 3, 4, 1, 4, 4, 1, 1, 1, 5, 5, 5, 2, 2, 2, 4, 2, 3, 1, 5, 5, 2, 1, 3, 1, 2, 2, 4, 5, 5, 3, 5, 2, 4,
				3, 1, 1, 4, 1, 1, 3, 4, 3, 5, 4, 5, 4, 5, 5, 1, 1, 5, 3, 5, 4, 5, 5, 1, 3, 1, 1, 4, 4, 4, 3, 3 };
		
		
		System.out.println(uniqueCkecker(b));

	}

}
