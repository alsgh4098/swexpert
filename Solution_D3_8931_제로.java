package ssafyalgo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D3_8931_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(in.readLine());
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < K; i++) {
				int input = Integer.parseInt(in.readLine());
				if(input !=0) {
					st.push(input);
				}else {
					st.pop();
				}
			}
			int sum=0;
			while(!st.isEmpty()) {
				sum += st.pop();
			}
			System.out.println("#" + t + " "+sum);
		}
	}

}
