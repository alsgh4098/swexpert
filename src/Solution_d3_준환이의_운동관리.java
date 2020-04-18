
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution_d3_준환이의_운동관리 {
	
	static int TC;
	static int low;
	static int high;
	static int input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			low = Integer.parseInt(st.nextToken());
			high = Integer.parseInt(st.nextToken());
			input = Integer.parseInt(st.nextToken());
			
			int res;
			
			if( low <= input && input <= high) {
				res = 0;
			}else if(high < input) {
				res = -1;
			}else {
				res = low - input;
			}
			
			System.out.printf("#%d %d\n",t,res);
		}

	}

}
