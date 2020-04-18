import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//범위 DP

public class Solution_역량_2115_벌꿀채취2 {
	
	static int N;
	static int M;
	static int C;
	
	static int[][] map;
	static int[][] Maxmap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			Maxmap = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					makeMaxmap(i,j,0,0,0);
				}
			}
			
			System.out.println("#"+t+" "+getMaxBenefit());
			
		}

	}// end main

	// map에서 칸마다 만들어질 수 있는 부분집합에서 최댓값을 갖는 부분 값 찾아서 Maxmap에 넣기.
	// cnt는 현재 범위에서 어디에 위치하고 있는지 위치.
	// 범위가 N-M까지이기 때문에 벗어날 일 없다.
	static void makeMaxmap(int x,int y,int cnt,int sum,int powsum) {
		if(sum > C) {
			return;
		}
		
		if(cnt == M) {
			if(powsum > Maxmap[x][y-M]) {
				Maxmap[x][y-M] = powsum;
			}
			return;
		}
		
		//선택
		makeMaxmap(x,y+1,cnt+1,sum+map[x][y],powsum+map[x][y]*map[x][y]);
		//비선택
		makeMaxmap(x,y+1,cnt+1,sum,powsum);
	}
	
	static int getMaxBenefit() {
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				for (int j2 = j+M; j2 <= N-M; j2++) {
					if(Maxmap[i][j]+Maxmap[j][j2] > max) {
						max = Maxmap[i][j]+Maxmap[j][j2];
					}
				}
				
				for (int j2 = i+1; j2 < N; j2++) {
					for (int k = 0; k <= N-M; k++) {
						if(Maxmap[i][j]+Maxmap[j2][k] > max) {
							max = Maxmap[i][j]+Maxmap[j2][k];
						}
					}
				}
			}
		}
		
		return max;
	}

}
