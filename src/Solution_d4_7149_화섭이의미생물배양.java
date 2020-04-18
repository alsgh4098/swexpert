import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_7149_화섭이의미생물배양 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc =sc.nextInt();
		
		for (int t2 = 1; t2 <= tc; t2++) {
			
			int min = Integer.MAX_VALUE;
			
			int s = sc.nextInt();
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			int c1 = s%10;
			int c2 = t%10;
			int c3 = a%10;
			
			boolean chck = (c1+c2+c3)%2==1? false:true;
			
			
			if(chck) {
				q.offer(new int[] {s,0});
				while(!q.isEmpty()) {
					int[] temp = q.poll();
					int value = temp[0];
					int day = temp[1];
					
					if(value == t) {
						if(day < min) {
							min = day;
						}
						break;
					}
					

					if(b!=1) {
						if( value*b <= t) {
							if( t%b == 0) {								
								q.offer(new int[] {value*b,day+1});
							}else {
								q.offer(new int[] {value+a,day+1});
							}
						}
					}
					
					if( value+a <= t) {
							q.offer(new int[] {value+a,day+1});
					}
					
				}
			}else {
				min = -1;
			}

			
			System.out.printf("#%d %d\n",t2,min);
			
		}
		


	}

}
