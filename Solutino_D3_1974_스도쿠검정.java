

import java.util.Arrays;
import java.util.Scanner;

public class Solutino_D3_1974_스도쿠검정 {

	public static void main(String[] args) {
		Scanner sc  = new  Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int [][] sudoku = new int[9][9];
			
			for(int x=0; x<9; x++) {
				for(int y=0; y<9; y++) {
					sudoku[x][y] = sc.nextInt();
				}
			}
			boolean[] sudo_true = {true,true,true,true,true,true,true,true,true};
			boolean[] sudo_chck =  {false,false,false,false,false,false,false,false,false};
			
			//  3by3
			int res_3x3 = 1;
			
			for(int j=0; j<3; j++) {
				for(int n=0; n<3; n++) {
					
					for(int x=0; x<3; x++) { 
						for(int y=0; y<3; y++) {
							sudo_chck[sudoku[x+j*3][y+n*3]-1] =  !sudo_chck[sudoku[x+j*3][y+n*3]-1];
//							System.out.print(sudoku[x+j*3][y+n*3] + " ");
						}
//						System.out.println();
					}
					
					if(!Arrays.equals(sudo_true, sudo_chck)) {
						res_3x3 = 0;
					}
					
					if(res_3x3 == 0) {
						break;
					}
					
					//sudo_chck 다시 false로 초기화.
					for(int k=0; k<9; k++) {
						sudo_chck[k] = false;
					}
				}
				if(res_3x3 == 0) {
					break;
				}
				
			}

			
			// 세로 9
			int res_colum= 1;
			
			
			for(int x=0; x<9; x++) {
				for(int y=0; y<9; y++) {
					sudo_chck[sudoku[y][x]-1] =  !sudo_chck[sudoku[y][x]-1];
				}
				if(!Arrays.equals(sudo_true, sudo_chck)) {
					res_colum = 0;
				}
				
				if(res_colum == 0) {
					break;
				}
				
				//sudo_chck 다시 false로 초기화.
				for(int k=0; k<9; k++) {
					sudo_chck[k] = false;
				}
			}
			
			// 가로 9
			int res_row = 1;
			
			for(int x=0; x<9; x++) {
				for(int y=0; y<9; y++) {
					sudo_chck[sudoku[x][y]-1] =  !sudo_chck[sudoku[x][y]-1];
				}
				if(!Arrays.equals(sudo_true, sudo_chck)) {
					res_row = 0;
				}
				
				if(res_row == 0) {
					break;
				}
				
				//sudo_chck 다시 false로 초기화.
				for(int k=0; k<9; k++) {
					sudo_chck[k] = false;
				}
			}
			
			int res = 0;
			
			if( res_row == 1 && res_colum == 1 && res_3x3 == 1) {
				res = 1;
			}
			
			System.out.printf("#%d %d\n",i,res);
		}

	}

}
