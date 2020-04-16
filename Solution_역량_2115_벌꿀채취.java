package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전탐색 : 부분집합 --> 조합

public class Solution_역량_2115_벌꿀채취 {
	
	static int N,M,C; // N 벌통크기, M 연속된 벌통수, C 채취량
	static int[][] map, maxMap; // map 입력된 벌통정보, maxMap i,j위치에서 가질 수 있는 최대이익

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			maxMap = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st =  new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			//1. 각 i,j위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산.
			makeMaxMap();
			//2. 두 일꾼의 조합.
			System.out.println("#"+t+" "+getMaxBenefit());
			
		}

	}// end main
	
	static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				makeMaxSubset(i,j,0,0,0);
			}
		}
	}
	
	// i : 행의 위치, j : 열의 위치, cnt : 고려한 원소수
	// sum : 부분집합에 속학 원소의 합.
	// powSum : 부분집합에 속학 원소의 이익.
	static void makeMaxSubset(int i, int j, int cnt,int sum, int powSum) {
		
		if(sum>C) return; // 부분집합의 합이 목표량 C를 초과하면 리턴.
		if(cnt == M) {
			// 0,0 M = 2
			// 0, 0:0 0,1:1 0,2:2
			if(maxMap[i][j-M] < powSum) {
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		
		// 여기가 핵심이네.
		// 선택과 비선택.
		
		// i,j 선택
		makeMaxSubset(i,j+1,cnt+1,sum+map[i][j],powSum+map[i][j]*map[i][j]);
		// i,j 비선택
		makeMaxSubset(i,j+1,cnt+1,sum,powSum);
		
	}
	
	private static int getMaxBenefit() {
		int max = 0, temp = 0; // max : 조합적 선택후의 최대 이익값.
		
		// 1. 일꾼 A 기준선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { // A일꾼
				//2. 일꾼 B선택
				// 같은 행 기준 선택
				for (int j2 = j+M; j2 <= N-M; j2++) {
					temp = maxMap[i][j] + maxMap[j][j2];
					if(max < temp) {
						max = temp;
					}
				}
				// 다음행 부터 마지막행가지 선택.
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp) {
							max = temp;
						}
					}
				}
			}
		}
		
		return max;
	}

}
