
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_8658_summation {
	
	static int max;
	static int min;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			String str = br.readLine();
			
			StringTokenizer st = new StringTokenizer(str);
			
			while(st.hasMoreTokens()) {
				char[] number = st.nextToken().toCharArray();
				
				int sum = 0;
				
				for (int i = 0; i < number.length; i++) {
					sum += number[i]-'0';
				}
				
				if(sum < min) {
					min = sum;
				}
				
				if(max < sum) {
					max = sum;
				}
				
			}
			
			System.out.printf("#%d %d %d\n",t,max,min);
		}

	}

}
