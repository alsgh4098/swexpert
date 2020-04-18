

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d3_8104_조만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10명씩 5개조 총 50명
		//
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int n = (N*K);
			
			int res = (n*(n+1)/2)/K;
			
			if( N%2 ==0) {
				System.out.print("#"+t+" ");
				for(int i=0; i<K; i++) {
					System.out.print(res+" ");
				}
				System.out.println();
			}else {
				
				n = (N+1)*K;
				int n_copy = n;
				res = (n*(n+1)/2)/K;
				System.out.print("#"+t+" ");
				for(int i=0; i<K; i++) {
					System.out.print((res-n_copy)+" ");
					n_copy--;
				}
				System.out.println();
			}

		}
		
	}

}
