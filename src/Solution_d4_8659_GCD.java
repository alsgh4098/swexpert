import java.util.Scanner;
// memoization
public class Solution_d4_8659_GCD {
	static int T;
	static int K;
	static long[] p;
	
	public static void main(String[] args) {
		p = new long[92];
		
		p[1] = 1L;
		p[2] = 2L;
		
		for (int i = 3; i < 92; i++) {
			p[i] = p[i-1] + p[i-2];
		}
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			K = sc.nextInt();
			
			System.out.printf("#%d %d %d\n",t,p[K+1],p[K]);
		}

	}

}
