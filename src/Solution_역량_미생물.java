import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Solution_역량_미생물 {
	
	static class Misaeng{
		int X;
		int Y;
		// 크기
		int S;
		// 방향
		int D;
		// 위치
		int XY;
		
		public Misaeng(int x, int y, int s, int d) {
			super();
			X = x;
			Y = y;
			S = s;
			D = d;
			XY = N*x+y;
		}
	}
	
	static int N,M,K;
	
	static ArrayList<Misaeng> list;
	
	// 1 상 2 하 3 좌 4 우
	static int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new ArrayList<Misaeng>();
			// 맵의 한 변
			N = Integer.parseInt(st.nextToken());
			// 격리시간
			M = Integer.parseInt(st.nextToken());
			// 미생물 수
			K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Misaeng(x,y,s,d));
			}
			
			System.out.println("#"+t+" "+timeGoes());
		}

	}// end main;
	
	static int timeGoes() {
		for (int i = 0; i < M; i++) {
			if(!moveMisaeng()) {
				// 시간이 다 흐르지 않았지만 미생물군집이 남아있지 않은경우 멈춘다.
				break;
			}else{
				MergeMisaeng();
			}
		}
		return MisaengSum();
	}
	
	private static void MergeMisaeng() {
		// 같은 위치의 미생물들을 합치기 전에 같은 위치의 미생물들을 붙어있게 정렬해준다.
		list.sort(new Comparator<Misaeng>() {
			@Override
			public int compare(Misaeng o1, Misaeng o2) {
				// 위치별은 오름차순 내림차순은 상관없다
				// 같은 위치인 경우만 붙어있게 하면된다.
				if(o1.XY>o2.XY) {
					return -1;
				}else if(o2.XY>o1.XY) {
					return 1;
				}else {
					return o2.S-o1.S;
				}
			}
		});
		
		for (int j = 0; j < list.size()-1; j++) {
			Misaeng ths = list.get(j);
			Misaeng tht = list.get(j+1);
            if (ths.XY == tht.XY) { // 위치가 같은 경우 미생물 수로 내림차순임. 다음놈을 걍 지우면 됨.
            	ths.S += tht.S; // next가 미생물 더 적으니까 흡수시키자.
                list.remove(j + 1);
                j--;
            }
		}
		
	}

	static boolean moveMisaeng() {
		for (int i = 0; i < list.size(); i++) {
			Misaeng mi = list.get(i);
			int nx = mi.X + dir[mi.D][0];
			int ny = mi.Y + dir[mi.D][1];
			// 이 아래 떄문에 3시간 걸림
			int nxy = N*nx+ny;
			// 가장자리에 닿을 경우
			// 방향과 사이즈 바꾼 미생물 리스트에 넣기
			if(nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
				int nd = changeDir(mi.D);
				int ns = mi.S/2;
				if(ns>0) {					
					mi.X = nx;
					mi.Y = ny;
					mi.S = ns;
					mi.D = nd;
					mi.XY = nxy;
				}else {
					list.remove(i);
					i--;
				}
			// 가장자리에 닿지 않고 이동하는 경우
			// 한 칸 이동함.
			}else {
				mi.X = nx;
				mi.Y = ny;
				mi.XY = nxy;
			}
		}
		
		// 미생물군집이 하나도 남아있지 않다면 false 남아있다면 true;
		if(list.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	static int MisaengSum() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).S;
		}
		return sum;
	}
	
	static int changeDir(int d) {
		switch(d) {
			case 1:
				return 2;
			case 2:
				return 1;
			case 3:
				return 4;
			case 4:
				return 3;
		}
		return -1;
	}

}
