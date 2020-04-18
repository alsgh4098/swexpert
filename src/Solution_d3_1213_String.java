
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_1213_String {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t <= 10; t++) {
			int TC = Integer.parseInt(br.readLine());
			
			String target = br.readLine();
			
			String str = br.readLine();
			
			int trg_len = target.length();
			
//			System.out.println(trg_len);
			
			int count = 0;
			
			for (int i = 0; i < str.length()-trg_len+1; i++) {
					if( str.substring(i, i+trg_len).equals(target) ) {
						count++;
					}
			}
			
			System.out.printf("#%d %d\n",TC,count);
			
		}
		

	}

}
