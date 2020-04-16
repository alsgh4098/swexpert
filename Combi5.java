package ssafyalgo0130;

import java.util.Arrays;

public class Combi5 {

	static int N;
	static int R;
	static int []nums;
	static int cnt;
	public static void main(String[] args) {
		N=5;
		R=3;
		cnt = 0;
		nums = new int[R];
		nCr(0,0);
		System.out.println(cnt);
	}
	public static void nCr(int start, int count) {
		if(R==count) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[count] = i+1;
			nCr(i+1,count+1);
		}
	}
}
