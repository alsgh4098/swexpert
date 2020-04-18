

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_조합 {

	static int T;
	static int N;
	static int R;
	static long cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data);
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			cnt = 1L;
			int []nums = new int[N+1];
			for (int i = 0; i <= N; i++) {
				if(i>=1) {
					nums[i] = i*nums[i-1] % 1234567891;
				}else {
					nums[i] = 1;
				}
			}
			System.out.println("#" + t + " " + (nums[N]));
		}
	}
}