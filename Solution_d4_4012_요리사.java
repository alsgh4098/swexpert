import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_4012_요리사 {
	
	static int[][] map;
	static int N;
	
	static int size;
	
	static int[] nums;
	
	static int[] res;
	
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			
			min = Integer.MAX_VALUE;
			
			map = new int[N][N];
			
			res = new int[2];
			
			size = (N*N-N)/2;
			
			nums = new int[size];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int n = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i < j) {
						nums[n] = map[i][j] + map[j][i];
						n++;
					}
				}
			}
			
			for (int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
			}
			
			combi(0,0);
			
			System.out.printf("#%d %d\n",t,min);
			System.out.println();
			
			
//			printMap(map);
			
			
			
		}
		

	}
	
	static void printMap(int[][] map){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	static void combi(int start, int count) {
		if(count == 2) {
			
			int sum = Math.abs( res[0] - res[1] );
			
			System.out.println("0      "+res[0]);
			
			System.out.println("1      "+res[1]);
			
			if(  sum < min ) {
				min = sum;
				System.out.println("minmin"+min);
			}
			
			return;
		}else {
			for (int i = start; i < size; i++) {
				res[count] = nums[i];
				combi(start+1,count+1);
			}
		}
	}

}
