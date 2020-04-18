import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_스타일리쉬들여쓰기{
	
	static int[][] frm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			frm = new int[N-1][4];
			
			char[] line = br.readLine().toCharArray();
			
			int rp = 0;
			int rm = 0;
			
			int cp = 0;
			int cm = 0;
			
			int sp = 0;
			int sm = 0;

			for (int j = 0; j < N-1; j++) {

				int dot_count = 0;
				
				for (int i = 0; i < line.length; i++) {
					if(line[i] == '(') {
						rp++;
					}else if(line[i] == ')'){
						rm++;
					}else if(line[i] == '{'){
						cp++;
					}else if(line[i] == '}'){
						cm++;
					}else if(line[i] == '['){
						sp++;
					}else if(line[i] == ']'){
						sm++;
					}
				}

				line = br.readLine().toCharArray();
				
				// 들여쓰기('.')의 갯수를 센다. 
				for (int i = 0; i < line.length; i++) {
					if(line[i] == '.') {
						dot_count++;
					}else {
						break;
					}
				}
				
				frm[j][0] = rp-rm;
				frm[j][1] = cp-cm;
				frm[j][2] = sp-sm;
				frm[j][3] = dot_count;
			}//
			
			
			// 방정식계산
			
			int R = -1;
			int S = -1;
			int C = -1;
			
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						boolean check = true;
						
						boolean check1 = false;
						boolean check2 = false;
						boolean check3 = false;
						
						for (int i = 0; i < N-1; i++) {
							if( r*frm[i][0] + c*frm[i][1] + s*frm[i][2] != frm[i][3]) {
								check = false;
							}else {
								if(frm[i][0] != 0) {
									check1 = true;
								}
								if(frm[i][1] != 0) {
									check2 = true;							
								}
								if(frm[i][2] != 0) {									
									check3 = true;
								}
							}
						}
						if(check) {
							if(check1) {								
								R = r;
							}
							if(check2) {		
								S = s;
							}
							if(check3) {	
								C = c;
							}
						}	
					}
				}
			}// end 방정식
			
			// 내 문장
			int[] res = new int[M];
			
			line = br.readLine().toCharArray();
			
			rp = 0;
			rm = 0;
			
			cp = 0;
			cm = 0;
			
			sp = 0;
			sm = 0;

			for (int j = 1; j < M; j++) {
				
				for (int i = 0; i < line.length; i++) {
					if(line[i] == '(') {
						rp++;
					}else if(line[i] == ')'){
						rm++;
					}else if(line[i] == '{'){
						cp++;
					}else if(line[i] == '}'){
						cm++;
					}else if(line[i] == '['){
						sp++;
					}else if(line[i] == ']'){
						sm++;
					}
				}
				
				line = br.readLine().toCharArray();
				
				res[j] = R*(rp-rm) + C*(cp-cm) + S*(sp-sm);
				
				if( rp-rm != 0 && R == -1) {
					res[j] = -1;
				}
				
				if( cp-cm != 0 && C == -1) {
					res[j] = -1;
				}
				
				if( sp-sm != 0 && S == -1) {
					res[j] = -1;
				}
				
				for (int i = 0; i < N-1; i++) {
					if(rp-rm == frm[i][0] && cp-cm == frm[i][1]
							&& sp-sm == frm[i][2]) {
						res[j] = frm[i][3];
						break;
					}
				}
				
				
			}
			
			sb.append("#"+t+" ");
			
			for (int i = 0; i < res.length; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			
		}// end tc
		
		System.out.println(sb);

	}// end main

}
