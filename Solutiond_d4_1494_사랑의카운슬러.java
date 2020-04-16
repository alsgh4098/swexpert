//package _0214_;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Solutiond_d4_1494_사랑의카운슬러 {
//
//	static int[] worms_x;
//	static int[] worms_y;
//	static int[] this_worm;
//	static int[] worm;
//	static int N;
//	static int min = Integer.MAX_VALUE;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int TC = Integer.parseInt(br.readLine());
//		
//		for (int t = 1; t <= TC; t++) {
//			N = Integer.parseInt(br.readLine());
//			
//			worms_x = new int[N];
//			worms_y = new int[N];
//			
//			worm = new int[2];
//			this_worm = new int[N];
//			
//			StringTokenizer st;
//			
//			// N개의 지렁이의 위치 좌표.
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				worms_x[i] = Integer.parseInt(st.nextToken());
//				worms_y[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			
//			
//		}
//		
//		N = 4;
//		worm = new int[N];
//		this_worm = new int[N];
//		
//
//	}
//	
//	static void solution(int grd_idx, int a_cnt, int b_cnt) {
//		if (a_cnt > N / 2 || b_cnt > N / 2) {
//			return;
//		} else {
//			if (grd_idx == N) {
//
//				int res = check();
//
//				if (res < min) {
//					min = res;
//				}
//				return;
//			} else {
//
//				gradient[grd_idx] = 1;
//				solution(grd_idx + 1, a_cnt + 1, b_cnt);
//				gradient[grd_idx] = 2;
//				solution(grd_idx + 1, a_cnt, b_cnt + 1);
//
//			}
//		}
//	}
//
//	static int check() {
//
//		int a_sum = 0;
//		int b_sum = 0;
//
//		for (int i = 0; i < map.length; i++) {
//			if (gradient[i] == 1) {
//				for (int j = 0; j < map.length; j++) {
//					if( i == j) {
//						continue;
//					}
//					if (gradient[j] == 1) {
//						a_sum += map[i][j];
//					}
//				}
//			} else if (gradient[i] == 2) {
//				for (int j = 0; j < map.length; j++) {
//					if( i == j) {
//						continue;
//					}
//					if (gradient[j] == 2) {
//						b_sum += map[i][j];
//					}
//				}
//			}
//		}
//
//		int res = ((a_sum - b_sum > 0) ? (a_sum - b_sum) : (b_sum - a_sum));
//
//		return res;
//	}
//
//}
