
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] count = new int[N];
			
			Arrays.fill(count, 1);
			
			for (int i = 0; i < arr.length-1; i++) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i] < arr[j] && count[i]+1 > count[j] ) {
						count[j]++;
					}
				}
			}
			
			Arrays.sort(count);
			
			System.out.printf("#%d %d\n",t,count[N-1]);
			
		}

	}

}
