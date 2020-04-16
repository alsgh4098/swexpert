package ssafyalgo0130;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(8);
		list.add(0);
		
		System.out.println(list.size());
		for(int a : list) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		list.add(3,-3);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			int a = list.get(i);
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
