

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5603_건초더미 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			int sum=0;
			int []hays = new int[N];
			for (int i = 0; i < N; i++) {
				hays[i] = Integer.parseInt(in.readLine());
				sum += hays[i];
			}
			int avg = sum/hays.length;
			int max  = 0;
			for(int i=0; i<N; i++) {
				max += Math.abs(avg-hays[i]);
			}
			
			System.out.println("#" + t + " " + max/2);
		}
	}

}
