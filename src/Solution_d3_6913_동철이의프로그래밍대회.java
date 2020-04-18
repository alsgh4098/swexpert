
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_6913_동철이의프로그래밍대회 {
	
	static int N;
	static int M;
	static int[] people;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			people = new int[N];
			
			
			
			// 행이 사람
			// 열이 문제수
			map = new int[N][M];
			
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < M; j++) {
						if(map[i][j] == 1) {
							count++;
						}
				}
				people[i] = count;
			}
			
			int max = Integer.MIN_VALUE;
			
			int max_cnt = 0;
			
			for (int i = 0; i < people.length; i++) {
				if( max < people[i]) {
					max = people[i];
				}
			}
			
			for (int i = 0; i < people.length; i++) {
				if( max == people[i]) {
					max_cnt++;
				}
			}
			
			System.out.printf("#%d %d %d\n",t,max_cnt,max);
			
		}
		
	}

}
