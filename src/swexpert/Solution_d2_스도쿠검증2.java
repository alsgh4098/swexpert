package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d2_스도쿠검증2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			int[][] map = new int[9][9];
			
			StringTokenizer st;
			
			//스도쿠맵 만들기
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					int number = Integer.parseInt(st.nextToken());
					map[i][j] = number;
				}
			}
			
			int res = 1;
			int[] sudoku_check = new int[9];
			int[] number;
			
			//스도쿠를 확인하기 위해 0~9까지의 어레이에 1을 채워주고
			//맵에서 값을 한줄씩 확인해나가면서 값의 횟수를 측정한다.
			//그리고 그 두개의 어레이를 같은지 비교한다.
			Arrays.fill(sudoku_check, 1);
			
			//가로확인
			for (int i = 0; i < map.length; i++) {
				number = new int[9];
				for (int j = 0; j < map.length; j++) {
					number[map[i][j]-1]++;
//					System.out.println(Arrays.toString(number));
				}
				if( !Arrays.equals(sudoku_check, number)) {
					res = 0;
					break;
				}
			}
			
			//세로확인
			for (int i = 0; i < map.length; i++) {
				number = new int[9];
				for (int j = 0; j < map.length; j++) {
					number[map[j][i]-1]++;
				}
				if( !Arrays.equals(sudoku_check, number)) {
					res = 0;
					break;
				}
			}
			
			//정방확인
			for (int i = 0; i < map.length; i += 3) {
				for (int j = 0; j < map.length; j += 3) {
					number = new int[9];

					number[map[i][j]-1]++;
					number[map[i][j+1]-1]++;
					number[map[i][j+2]-1]++;
					
					number[map[i+1][j]-1]++;
					number[map[i+1][j+1]-1]++;
					number[map[i+1][j+2]-1]++;

					number[map[i+2][j]-1]++;
					number[map[i+2][j+1]-1]++;
					number[map[i+2][j+2]-1]++;
					
					if( !Arrays.equals(sudoku_check, number)) {
						res = 0;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,res);
			
		}

	}

}
