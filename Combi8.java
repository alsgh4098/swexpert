package algo0206;

import java.util.Arrays;

public class Combi8 {
	static int N = 3;
	static int R = 2;
	static int[] re;
	public static void main(String[] args) {
		re = new int[R];
		comb(N,R,0,0);

	}
	
	public static void comb(int n, int r, int start, int count) {
		if(r==count) {
			System.out.println(Arrays.toString(re));
			return;
		}
		for (int i = start; i < n; i++) {
			re[count] = i+1;
			comb(n,r,i+1, count+1);
		}
	}

}
