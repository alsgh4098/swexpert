import java.util.Scanner;

public class Solution_d4_4012_요리사 {
	
	static int N;
	static int[][] map;
	static int[] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			arr = new int[N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			solution(0,0);
			
			System.out.printf("#%d %d\n",t,min);
			
		}

	}
	
	public static void solution(int start, int count) {
		if(count == N/2 ) {
			int res = solution2();
			
			if( res < min) {
				min = res;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(arr[i] != 1) {
				arr[i] = 1;
				solution(i+1,count+1);
				arr[i] = 0;
			}
		}
	}
	
	public static int solution2() {
		int sum1 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( arr[i]==1 && arr[j] ==1) {
					sum1 += map[i][j];
				}
			}
		}
		
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( arr[i]!=1 && arr[j] !=1) {
					sum2 += map[i][j];
				}
			}
		}
		
		return Math.abs(sum1-sum2);
	}

}
