import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_요리사_교수님 {
	
	static int N,min;
	static int[][] S;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			S = new int[N][N];
			
			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			
			comb(0,0);
			
			System.out.println("#"+tc+" "+min);
		}
		
		br.close();
	}
	
	static void comb(int cnt, int cur) {
		if(cur>= N) return;
		if(cnt==N/2) {
			int sum1 = 0;
			int sum0 = 0;
			for (int i = 0; i < N; i++) {
				for(int j=i+1; j < N; j++ ) {
					if(visited[i] != visited[j]) continue;
					if(visited[i]) sum1+=S[i][j] + S[j][i];
					else sum0 +=S[i][j] + S[j][i];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum0));
			return;
		}
		
		for (int i = cur; i < N; i++) {
			
			visited[i] = true;
			comb(cnt+1,i+1);
			visited[i] = false;
		}
	}
}