package _0214_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_4751_다솔이의다이아몬드장식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			String str = br.readLine();

			char[] chr_arr = str.toCharArray();

			StringBuffer sb = new StringBuffer();

//			for (int i = 0; i < chr_arr.length; i++) {
				for (int j = 0; j < chr_arr.length; j++) {
					sb.append("..#..");
					if(chr_arr.length != 0 && j != chr_arr.length-1) {
						sb.delete(sb.length()-1, sb.length());
					}
				}
				sb.append("\n");
				for (int j = 0; j < chr_arr.length; j++) {
					sb.append(".#.#.");
					if(chr_arr.length != 0 && j != chr_arr.length-1) {
						sb.delete(sb.length()-1, sb.length());
					}
				}
				sb.append("\n");
				for (int j = 0; j < chr_arr.length; j++) {
					sb.append(String.format("#.%c.#", chr_arr[j]));
					if(chr_arr.length != 0 && j != chr_arr.length-1) {
						sb.delete(sb.length()-1, sb.length());
					}
				}
				sb.append("\n");
				for (int j = 0; j < chr_arr.length; j++) {
					sb.append(".#.#.");
					if(chr_arr.length != 0 && j != chr_arr.length-1) {
						sb.delete(sb.length()-1, sb.length());
					}
				}
				sb.append("\n");
				for (int j = 0; j < chr_arr.length; j++) {
					sb.append("..#..");
					if(chr_arr.length != 0 && j != chr_arr.length-1) {
						sb.delete(sb.length()-1, sb.length());
					}
				}
//			}
			
			System.out.println(sb.toString());

		}

	}

}
