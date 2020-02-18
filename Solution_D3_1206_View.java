

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(in.readLine());
			int house = 0;
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data);
			int i=0;
			int[] apartment = new int[N];
			while(st.hasMoreTokens()){
				apartment[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			for (int j = 2; j < apartment.length-2; j++) {
				int l2 = apartment[j] - apartment[j-2];
				int l1 = apartment[j] - apartment[j-1];
				int r1 = apartment[j] - apartment[j+1];
				int r2 = apartment[j] - apartment[j+2];
				if(l1>0 && l2 >0 &&r1>0&&r2>0) {
					house += Math.min(Math.min(l1,l2), Math.min(r1, r2));
				}
			}

			System.out.println("#" + t + " " + house);
		}
	}
}
