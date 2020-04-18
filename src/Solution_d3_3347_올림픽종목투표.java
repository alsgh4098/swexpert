
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_3347_올림픽종목투표 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st ;

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A_list = new int[N];
			int[] A_list2 = new int[N];
			int[] B_list = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A_list[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B_list[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < B_list.length; i++) {
				for (int j = 0; j < A_list.length; j++) {
					if(A_list[j] <= B_list[i]) {
						A_list2[j]++;
						break;
					}
				}
			}
			
			int res = 0;
			int max = 0;
			
			for (int i = 0; i < A_list2.length; i++) {
				if(max < A_list2[i]) {
					max = A_list2[i];
					res = i+1;
				}
			}
			
			System.out.printf("#%d %d\n",t,res);
			
		}
	}

}
