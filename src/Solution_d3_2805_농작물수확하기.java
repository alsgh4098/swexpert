
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_2805_농작물수확하기 {
	
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		int[][] map;
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			//입력
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				char[] chr_arr = str.toCharArray();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = chr_arr[j]-'0';
				}
			}
			
			int sum = 0;
			
			
			for (int i = 0; i < map.length; i++) {
				for (int j = Math.abs(N/2-i); j < N-Math.abs(N/2-i); j++) {
					sum += map[i][j];
				}
			}
			
			
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			System.out.printf("#%d %d\n",t,sum);
			
			
		}
	}

}
