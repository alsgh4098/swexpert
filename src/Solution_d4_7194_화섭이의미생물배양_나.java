import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_7194_화섭이의미생물배양_나 {
	
	static int S,T,A,B;
	
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			
			min = Integer.MAX_VALUE;
			// 초기값
			S = sc.nextInt();
			// 목적값
			T = sc.nextInt();
			// 더하기
			A = sc.nextInt();
			// 곱하기
			B = sc.nextInt();
			
			if(B == 1 ) {
				if((T-S)%A == 0 ) {					
					min = (T-S)/A;
				}
			}else {				
				bfs(T);
			}
			System.out.println("#"+t+" "+(min==Integer.MAX_VALUE?-1:min));
		}
	}

	private static void bfs(int from) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {from,0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int num = temp[0];
			int cnt = temp[1];
			
			if(num==S) {
				if(min>cnt) {
					min = cnt;
					return;
				}
			}
			
			if(num%B == 0 && num/B >= S) {
				q.offer(new int[] {num/B,cnt+1});
			}else if(num-A >= S){
				q.offer(new int[] {num-A,cnt+1});
			}
		}
		
	}
	
	private static void dfs(int now, int cnt) {
		if(now==S) {
			if(min>cnt) {
				min = cnt;
				return;
			}
		}
		
		if(now<S) {
			return;
		}
		
		if(now%B == 0 && now/B >= S) {
			dfs(now/B,cnt+1);
		}else if(now-A>=S){
			dfs(now-A,cnt+1);
		}
	}

}
