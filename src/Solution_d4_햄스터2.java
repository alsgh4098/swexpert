
/*https://ssongkr.github.io/swea-8275/
위 블로그보고 만들었슴.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_햄스터2 {

	static int N,M,X;
	static int[] room;
	static ArrayList<Room> list;
	static Pair[] room_cnt;
	
	public static class Room{
		int s = 0;
		int f = 0;
		int val = 0;
		public Room(int s, int f, int val) {
			super();
			this.s = s;
			this.f = f;
			this.val = val;
		}
	}
	
	public static class Pair implements Comparable<Pair>{
		int key;
		int val;
		
		public Pair(int key, int val) {
			super();
			this.key = key;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.val - this.val;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 우리(햄스터 방)
			N = Integer.parseInt(st.nextToken());
			// 햄스터 수
			X = Integer.parseInt(st.nextToken());
			// 제약 조건 수
			M = Integer.parseInt(st.nextToken());
			// 몇번 방이 제일 많이 나왔는지 세기위해 만든 배열.
			
			// 조건에맞는 방을 만들 배열.
			room = new int[N];
			// 몇번방부터 몇번방까지 몇명이 들어있는지에 대한 제약 조건
			list = new ArrayList<Room>();
			room_cnt = new Pair[N];			
			for (int i = 0; i < room_cnt.length; i++) {
				// key값만 다 넣어 놓음.
				room_cnt[i] = new Pair(i,0);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int f = Integer.parseInt(st.nextToken()) - 1;
				int val = Integer.parseInt(st.nextToken());
				
				// 몇번방부터 몇번방까지 몇명이 들어있는지에 대한 정보를 담는다.
				list.add(new Room(s,f,val));
				
				// 조건에 몇번 방이 제일 많이 나왔는지 세야한다.
				for (int j = s; j <= f; j++) {
					room_cnt[j].val++;
				}
			}// end input

			
			Arrays.fill(room, X);
			Arrays.sort(room_cnt);
			
			if(dfs(0)) {
				System.out.print("#"+t+" ");
				for (int i = 0; i < room.length; i++) {
					System.out.print(room[i]+" ");
				}
			}else {
				System.out.print("#"+t+" "+"-1");
			}
			System.out.println();
			
		}

	}// end main
	
	
	static boolean dfs(int cnt) {
		
		// 조건에 걸리지 않는 방들은 최대로 채워놓고 종료해야하기때문에 
		// room_cnt[cnt].val == 0 조건이 붙는다.
		if(cnt == N || room_cnt[cnt].val == 0) {
			return same();
		}
		
		for (int i = 0; i <= X; i++) {
			room[room_cnt[cnt].key] = i;
			if(dfs(cnt+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean same() {
		for (Room r: list) {
			int sum = 0;
			for(int j = r.s; j <= r.f; j++) {
				sum += room[j];
			}
			// 주어진 방들의 마리수 제한에 만족하지 못하면 false;
			if( sum != r.val) {
				return false;
			}
		}
		return true;
	}
	


}
