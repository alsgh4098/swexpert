import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;


public class Solution_d4_염라대왕의이름정렬 {
	
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			Set<String> set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length()) {
						return 1;
					}else if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}else {
						return -1;
					}
				}
				
			});
			
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				
				if(!set.contains(line)) {
					set.add(line);
				}
			
			}
			
			
			System.out.println("#"+t);
			
			Iterator<String> iter = set.iterator();
			
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
			
		}
		
	}

}
