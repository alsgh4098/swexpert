import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1240단순2진암호코드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			String str = null;
			String str2 = null;
			
			for (int i = 0; i < row; i++) {
				str = br.readLine();
				if(str.contains("1")){
					str2 = str;
				}
			}
			
//			System.out.println(str2);
			
//			char[] chr_arr = str.toCharArray();
			int lastIndex = str2.lastIndexOf('1');
			str2 = str2.substring(lastIndex-55, lastIndex+1);
			int[] arr = new int[8];
			int n = 0;
			int k = 0;
			while(true) {
				if( str2.substring(n,n+7).equals("0001101")) {
					arr[k] = 0;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0011001")) {
					arr[k] = 1;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0010011")) {
					arr[k] = 2;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0111101")) {
					arr[k] = 3;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0100011")) {
					arr[k] = 4;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0110001")) {
					arr[k] = 5;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0101111")) {
					arr[k] = 6;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0111011")) {
					arr[k] = 7;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0110111")) {
					arr[k] = 8;
					k++;
					n+=7;
				}else if( str2.substring(n,n+7).equals("0001011")) {
					arr[k] = 9;
					k++;
					n+=7;
				}else {
					n++;
				}
				
				if(k == 8) {
					break;
				}

			}
			
			int sum = 0;
			for (int i = 0; i < arr.length; i+=2) {
				sum += arr[i];
			}
			
			sum *= 3;
			
			for (int i = 1; i < arr.length; i+=2) {
				sum += arr[i];
			}
			

			int res = 0;
//			System.out.println(sum);
//			System.out.println(arr[7]);
			if(sum%10 == 0) {
				for (int i = 0; i < arr.length; i++) {
					res += arr[i];
				}
			}else {
				res = 0;
			}
			
			System.out.printf("#%d %d\n",t,res);
			
		}

	}

}
