package ssafyalgo0130;

import java.util.Arrays;

public class Perm5 {

	static int N;
	static int R;
	static int[] nums;
	static int cnt;

	public static void main(String[] args) {
		N = 5;
		R = 3;
		cnt = 0;
		nums = new int[R];
		nPr(0, 0);
		System.out.println(cnt);
	}

	public static void print(int[] n) {
		System.out.println(Arrays.toString(n));
		return;
	}

	public static void nPr(int flag, int count) {
		if (R == count) {
			cnt++;
			print(nums);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}else {
				nums[count] = i+1;
				nPr(flag | (1 << i), count + 1);
			}
		}
	}
	

}
