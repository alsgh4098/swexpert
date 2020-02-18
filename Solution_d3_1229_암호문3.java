

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d3_1229_암호문3 {
	static ArrayList<Integer> ps_list;
//	static ArrayList<Object> m_list;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=1; i<=10; i++) {
			
			ps_list = new ArrayList<>();
//			m_list = new ArrayList<>();
			
			int ps=sc.nextInt();
			
			System.out.println(ps);
			for(int j=0; j<ps; j++) {
				while (!sc.hasNextInt()) {
	                sc.next();
				}
				ps_list.add(Integer.valueOf(sc.nextInt()));
			}
			
			while (!sc.hasNextInt()) {
                sc.next();
			}
			int m = sc.nextInt();
			System.out.println("m : "+m);
			
			while (!sc.hasNextInt()) {
                sc.next();
			}
			for(int j=0; j<m*3; j++) {
				String c = sc.next();
				if(c.equals('l')) {
					int index = sc.nextInt();
					int count = sc.nextInt();
					
					for(int k=0; k<count; k++ ) {
						ps_list.add(index, (Integer.valueOf(sc.nextInt())));
					}
					
				}else if(c.equals('D')) {
					int index = sc.nextInt();
					int count = sc.nextInt();
					
					for(int k=0; k<count; k++) {
						ps_list.remove(index);
					}
				}
			}
			
			System.out.printf("#%d ",i);
			for(int k=0; k<10; k++) {
				System.out.print(ps_list.get(k)+" ");
			}
			System.out.println();
			
			
		}

	}

}
