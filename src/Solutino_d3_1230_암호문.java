
import java.util.*;

public class Solutino_d3_1230_암호문 {
	static Scanner sc;
	static ArrayList<Integer> nums;

	static void insert() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < y; i++)
			nums.add(x + i, sc.nextInt());
	}

	static void delete() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < y; i++)
			nums.remove(x);
	}

	static void append() {
		int y = sc.nextInt();
		for (int i = 0; i < y; i++)
			nums.add(sc.nextInt());
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			nums = new ArrayList<Integer>();
			for (int i = 0; i < N; i++)
				nums.add(sc.nextInt());
			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				char command = sc.next().charAt(0);
				switch (command) {
				case 'I':
					insert();
					break;
				case 'D':
					delete();
					break;
				case 'A':
					append();
					break;
				}
			}
			System.out.format("#%d", tc);
			for (int i = 0; i < 10; i++) {
				System.out.format(" %d", nums.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}