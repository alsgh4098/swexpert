import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//package FightingDDi~~~~
public class Solution_d4_4408_자기방찾아가기 {
	
	static int T;
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 화이팅합시다
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <=TC; t++) {
			N = sc.nextInt();
			PriorityQueue<Room> rs = new PriorityQueue<>(new RCT());
			for (int i = 0; i < N; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				rs.add(new Room(s,e));
			}
			
			int [] room = new int[201];
			
			while(!rs.isEmpty()) {
				Room rm = rs.poll();
				int s = rm.s;
				int e = rm.e;
				
				for (int i = s; i <= e; i++) {
					room[i]++;
				}
			}
			
			Arrays.sort(room);
			
			System.out.printf("#%d %d\n",t,room[200]);
		}

	}
	
	public static class Room{
		int s;
		int e;
		int d;
		
		@Override
		public String toString() {
			return "Room [s=" + s + ", e=" + e + ", d=" + d + "]";
		}

		public Room(int s, int e) {
			this.s = s;
			this.e = e;
			if(s > e) {
				int t = this.s;
				this.s = this.e;
				this.e = t;
			}
			
			if(s%2==0) {
				this.s = this.s/2;
			}else {
				this.s = (this.s+1)/2;
			}
			if(e%2==0) {
				this.e = this.e/2;
			}else {
				this.e = (this.e+1)/2;
			}
			
			d = Math.abs(this.e-this.s);
		}
	}
	
	public static class RCT implements Comparator<Room>{

		// 0 은 같다.
		// 양수는 바꾼다.
		// 음수는 바꾸지 않는다.
		@Override
		public int compare(Room o1, Room o2) {
			
			if( o1.d > o2.d) {
				return -1;
			}else if(o1.d < o2.d) {
				return 1;
			}else {
				// 거리는 같지만 시작 순서에 차이가 있을 때.
				if( o1.s > o2.s) {
					return 1;
				}else if(o1.s < o2.s) {
					return -1;
				}else {
					return 0;
				}
			}
		}
		
	}

}
