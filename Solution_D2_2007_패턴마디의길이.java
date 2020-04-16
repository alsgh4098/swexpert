package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2007_패턴마디의길이 {

	static int T;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String data = in.readLine();
			int j=0;
			for (int i = 1; i < data.length(); i++) {
				if(data.charAt(j) == data.charAt(i)) {
					j++;
				}else {
					j=0;
				}
			}
			
			
			System.out.println("#" + t + " " + (data.length()-j));
		}
	}

}
