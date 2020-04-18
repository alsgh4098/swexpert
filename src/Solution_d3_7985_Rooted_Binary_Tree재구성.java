

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class  Solution_d3_7985_Rooted_Binary_Tree재구성{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			String[] nums = br.readLine().split(" ");
			int degree = 0;
			int len = nums.length;
			int sqrt = 1;
			while (sqrt < len + 1) {
				sqrt *= 2;
				degree++;
			}
			
			bw.write("#"+test_case+" ");
			for (int i = degree; i > 0; i--) {
				int idx = (int) Math.pow(2, i - 1);
				int interval = idx*2;
				idx--;
				bw.write(nums[idx]);
				while (idx + interval < len) {
					idx += interval;
					bw.write(" "+nums[idx]);
				}
				bw.write('\n');
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
