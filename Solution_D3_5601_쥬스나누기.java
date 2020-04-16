

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5601_쥬스나누기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				System.out.print(1 + "/" + N + " ");
			}
			System.out.println();
		}
	}

}
