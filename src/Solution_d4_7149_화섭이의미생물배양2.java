import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_7149_화섭이의미생물배양2 {
	
	static int s;
	static int t;
	static int a;
	static int b;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc =sc.nextInt();
		
		for (int t2 = 1; t2 <= tc; t2++) {
			
			int min = Integer.MAX_VALUE;
			
			s = sc.nextInt();
			t = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
		
			solution(t,0);

			
			System.out.printf("#%d %d\n",t2,min);
			
		}

	}
	
	public static void solution(int val,int count) {
		if(s==val) {
			if(min > count) {
				min = count;
				System.out.println("thisthis");
			}
			System.out.println("kjnjknkj");
			return;
		}
		
		if(val <= 0) {
			return;
		}

		if(val%b == 0) {
			if(val/b < s) {
				solution(val-a,count+1);
			}else if(b != 1) {
				solution(val/b,count+1);					
			}
		}else {
			solution(val-a,count+1);
		}
		
	}

}
