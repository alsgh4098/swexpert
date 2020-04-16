package ssafyalgo0129;

import java.util.Arrays;

public class Combi2 {

	static int N=4, cnt;
	static int R=2;
	static int[] nums;
	public static void main(String[] args) {
		cnt = 0;
		nums = new int[R];
		combi(0,0);
		System.out.println(cnt);
	}

	public static void combi(int start, int count) {
		if (count == R) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < N; i++) {
			nums[count] = i+1;
			combi(i+1,count+1);
		}
	}
}
