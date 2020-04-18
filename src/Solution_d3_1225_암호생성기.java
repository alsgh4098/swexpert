import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> res_list = new ArrayList<>();
		
		for(int t=1; t<=10; t++) {
			int tc = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0; i<8; i++) {
				int number =sc.nextInt();
				list.add(number);
				
			}
			
			int minus = 1;
			
			while( true ) {
				if(minus==6) {
					minus = 1;
				}
//				System.out.println(minus);
				int a = list.get(0)-minus;
				minus++;
//				System.out.println(a);
				list.add(a);
				list.remove(0);
				
				if(list.get(7) <=0) {
					list.set(7, 0);
					break;
				}
			}

//			list.add(0);
//			list.remove(0);
			
			System.out.print("#"+t+" ");
			for(int k=0; k<8; k++) {
				System.out.print(list.get(k)+" ");
			}
			System.out.println();
		}
		

	}

}
