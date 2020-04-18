
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5215_햄버거다이어트 {
	
		static int N;
		static int K;
		static int max = Integer.MIN_VALUE;
		static int[] kal;
		static int[] satisfaction;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			kal = new int[N];
			satisfaction = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				satisfaction[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0,0);
			System.out.println("#"+t+" "+max);
			
		}
		
	}
	
	public static void dfs(int start, int sum_kal,int sum_sat) {
		if( start+1 > N) {
			if( max < sum_sat && K >= sum_kal) {
				max = sum_sat;
			}
			return;
		}
		dfs(start+1,sum_kal,sum_sat); // 선택을 안하는 경우.
		dfs(start+1,sum_kal+kal[start],sum_sat+satisfaction[start]); // 선택을 하는 경우.
	}

}
