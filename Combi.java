package ssafyalgo0129;

public class Combi {

	static int N = 5;
	static int R = 3;
	static int[] nums;
	static int[] cc = { -1, -3, 4, -5, 6 };
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {

		nums = new int[R];
		combi(0, 0);
		System.out.println(max);
	}

	public static void combi(int start, int count) {
		if (count == R) {
			int tmp = 1;
			for (int i = 0; i < nums.length; i++) {
				tmp *= nums[i];
			}
			if(tmp > max) {
				max = tmp;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nums[count] = cc[i];
			combi(i + 1, count + 1);
		}
	}
}
