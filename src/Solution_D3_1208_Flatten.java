

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int dump = Integer.parseInt(in.readLine());
			int[] tower = new int[100];
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data);
			for (int i = 0; i < 100; i++) {
				tower[Integer.parseInt(st.nextToken())-1]++;
			}
			while (dump >= 0) {
				int indexMax = 0;
				int indexMin = 0;
				for (int i = 0; i < 100; i++) {
					if(tower[i] != 0 && indexMax < i) {
						indexMax = i;
					}
					if(indexMin > i && tower[i] !=0) {
						indexMin= i;
					}
				}
				tower[indexMax]--;
				tower[indexMin]--;
				dump--;
			}
			int max = 0;
			int min = 0;
			for(int i=0; i<100; i++) {
				if(tower[i] != 0) {
					min = i;
					break;
				}
			}
			for(int i=99; i>=0; i--) {
				if(tower[i] !=0) {
					max = i;
					break;
				}
			}
			int gap = max - min;
			System.out.println("#" + t + " " + gap);
		}
	}

}
