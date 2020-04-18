import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soluition_d3_최대상금 {
	
	static int change_cnt;
	static String number;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			
		    number = st.nextToken();
			change_cnt = Integer.parseInt( st.nextToken() );
			
//			int[] number_list = new int[number.length()];
//			
//			for (int i = 0; i < number_list.length; i++) {
//				number_list[i] = number.charAt(i)-'0';
//			}
//			
//			bubbleSort(number_list);
//			
//			char[] chr_arr2 = new char[number_list.length];
//			
//			for (int i = 0; i < chr_arr2.length; i++) {
//				chr_arr2[i] = Character.forDigit(number_list[i], 10);
//			}
			
			char[] chr_arr = number.toCharArray();
			
			solution(chr_arr,0);
			
			System.out.printf("#%d %d\n",t,max);
			
		}
	}
	
	static void solution(char[] chr_arr,int count) {
		if(count == change_cnt) {
			String number = new String(chr_arr);
			
			if( max < Integer.parseInt(number) ) {
				max = Integer.parseInt(number);
			}
			return;
		}else {
			for (int i = 0; i < chr_arr.length; i++) {
				for (int j = i+1; j < chr_arr.length; j++) {
					if( (chr_arr[i]-'0') <= (chr_arr[j]-'0' ) ) {
						char chr = chr_arr[j];
						chr_arr[j] = chr_arr[i];
						chr_arr[i] = chr;
						solution(chr_arr,count+1);
						chr = chr_arr[j];
						chr_arr[j] = chr_arr[i];
						chr_arr[i] = chr;
					}
				}
			}
		}
	}
	
	static void bubbleSort(int[] list) {
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length-1; j++) {
				if(list[j] < list[j+1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}

}
