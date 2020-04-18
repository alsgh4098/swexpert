
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_화섭이의미생물배양 {

	static long s;
	static long t;
	static long a;
	static long b;
	static long min;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int c = 1; c <= tc; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			s = Long.parseLong(st.nextToken());
			t = Long.parseLong(st.nextToken());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			min = Long.MAX_VALUE;
			
			if(b==1) {
				if((t-s)%a==0) {					
					min=(t-s)/a;
				}
			}else {				
				solution(t,0);
			}
			
			if(min==Long.MAX_VALUE) {
				min = -1;
			}
			
			System.out.printf("#%d %d\n",c,min);


		}

	}
	
	public static void solution(long t,long day) {

		
		if( s==t ) {
			if(min > day) {
				min = day;
			}
			return;
		}
		
		if( t < s) {
			return;
		}

		if(t%b == 0) {
			if(t/b < s) {
				solution(t-a,day+1);		
			}else {
				solution(t/b,day+1);
			}
		}else {
			solution(t-a,day+1);
		}

		
	}

}
