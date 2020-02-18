

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5642_합 {

	static int T;
	static int N;
	static int[] nums;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(in.readLine());
			nums = new int[N];
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data);
			boolean allMinus = true;
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				if (allMinus || nums[i] >= 0) {
					allMinus = false;
				}
			}

			max = Integer.MIN_VALUE;
			int tmp = 0;
			if (!allMinus) {
				for (int i = 0; i < nums.length; i++) {
					tmp += nums[i];
					max = Math.max(max, tmp);
					if(tmp<0) {
						tmp = 0;
					}
				}
			}else {
				for(int i=0; i<nums.length; i++) {
					max = Math.max(max, nums[i]);
				}
			}

			System.out.println("#" + t + " " + max);
		}
	}

}
