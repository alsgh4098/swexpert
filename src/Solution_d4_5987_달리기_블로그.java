import java.io.*;
import java.util.*;

public class Solution_d4_5987_달리기_블로그 {
	static int n, m;
	static long[] cache;
	static List<Integer>[] front;
	
	public static void main(String[] args) throws Exception {
		// MyScanner sc = new MyScanner();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(4096);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			// 선수-i의 앞에 올 수 없는 선수를 저장하기 위한 변수.
			front = new ArrayList[n];
			for(int i=0; i<n; i++) {
				front[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<m; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				front[y].add(x);
				
			}
			// 현재 앞에 있는 선수를 기준으로 가능한 경우의 수를 저장한다. 
			cache = new long[1 << n];
			Arrays.fill(cache, -1);
			sb.append("#").append(t).append(" ").append(dp(0, 0));
		}
		System.out.print(sb);
		
		sc.close();
	}
	
	public static long dp(int msk, int cur) {
		// 모든 선수가 필드에 놓였을 경우 1을 리턴한다.
		if(msk == (1 << n) - 1) {
			return 1;
		} else if(cache[msk] != -1) {
			return cache[msk];
		}
		
		// cache 값을 아직 구하지 않은 경우 현재 Bitmask에 해당하는 선수들이 앞에 있을 때,
		// 다음에 선수 i가 올때 가능한 경우의 수를 더해준다.
		cache[msk] = 0;
		for(int i=0; i<n; i++) {
			// msk에다가 i번째 선수를 세울 건데, 이미 그 선수가 안세워져 있을때, msk & (1 << i)) == 0 
			// msk에다가 i번째 선수를 세울 건데, valid(msk, i)를이용해서 확인, 
			// 어떻게 확인하냐면, front[cur]를 통해서 cur앞에 있어야 하는 선수들을 꺼내서 
			if((msk & (1 << i)) == 0 && valid(msk, i)) {
				cache[msk] += dp(msk | (1 << i), i);
			}
		}
		return cache[msk];
	}
	
	// 나보다 빠른 선수가 앞에 있을때만 유효하다.
	public static boolean valid(int msk, int cur) {
		for(int node: front[cur]) {
			
			// 예를들면
			// N=3의 이 문제의 예제에서
			// 110이 항상 만족해야 하는데
			// 여기서 0번째 선수를 세우고 싶은경우에는
			// 010 100을 만족하는 msk만 가능하다.
			// 즉, 1번째 선수와 2번째 선수를 먼저 세워야 한다.
			if((msk & 1 << node) > 0) {
				return false;
			}
		}
		return true;
	}
}