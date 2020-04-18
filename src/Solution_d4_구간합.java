import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_구간합 {
	
	static int[] high;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int s;
			int f;
			
			high = new int[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			// 111 112
//			int sum = 0;
			
			// 0 1 2 3 4 5 6 7 8 9 10
			// 10 11 12 13 14 15 16 17 18 19 20 ...
			// 98 99 100
			// 110 111 112 113 114 115 116 117 118 119 120
			// 121 122 123 124 125 126 127 128 129 130 
			// 198 199 200 201
			
			// 10 1 -9 1
			// 11 2 -9 1
			// 12 3 -9 1
			// 20 2 -18 2
			// 21 3 -18 2
			// 22 4 -18 2
			// 23 5 -18 2
			// 55 10 -45 5
			// 99 18 -81 9
			
			// 2번째 자리수가 바뀌면 9의 배수가 1씩 오름.
			// 3번째 자리수가 바뀌면 9의 배수가 2씩 오름.
			// 4번째 자리수가 바뀌면 9의 배수가 3씩 오름.
			
			// 100 1 -99 11 2
			
			// 101 2 -99 11 2
			// 111 3 -108 12 3
			// 112 4 -108 12 3
			// 122 5 -117 13 4
			// 200 2 -198 22 13
			
			// 888 24 -864 96 
			// 991 19 -972 108
			// 999 27 -972 108
			
			// 1000 1 -999 111
			// 1101 3 -1008 112
			// 2358 18 -2340 260
			
			
			
			
			int sum = 0;
			
			int n = 1;
			
			int zero_nine = 45;
			
			boolean finish = false;
			
			while(true) {
				
				while( s%10 !=0) {
					high[s%10]++;
					s++;
					if( s==f) {
						finish = true;
						break;
					}
				}
				
				if(finish) {
					break;
				}
				
				int i = 0;
				
				while( f%10 !=9) {
					high[f%10]++;
					f--;
				}
				int num = (f-s+1)*n;
				
				sum += num*zero_nine;
				
				n *= 10;
				
				s /= 10;
				f /= 10;
				
				if(f == 0) {
					break;
				}
				
			}
			
			for (int i = 1; i < 10; i++) {
				sum += i*high[i];
			}
			
			
			System.out.println("#"+t+" "+sum);
			/// 111 11 18 1
			
			// 1 2 3 4 5 6 7 8 9 10
		}
		
		//1246
		// 13 -1233 9 137

	}

}
