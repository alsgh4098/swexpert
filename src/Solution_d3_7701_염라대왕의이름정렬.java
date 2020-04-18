
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
 
 
public class Solution_d3_7701_염라대왕의이름정렬 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int i=1; i<=T; i++) {
            TreeSet<String> ts = new TreeSet<>();
            ArrayList<String> list = new ArrayList<>();
 
            int T2 = sc.nextInt();
             
            for(int j=1; j<=T2; j++) {
                ts.add(sc.next());
            }
             
            Iterator<String> iter = ts.iterator();
            while( iter.hasNext() ) {
                list.add(iter.next());
            }
            list.sort(new NC());
             
            System.out.println("#"+i);
             
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
     
    public static class NC implements Comparator<String>{
 
        @Override
        public int compare(String o1, String o2) {
            if( o1.length() < o2.length()) {
                return -1;
            }else if( o1.length() > o2.length()) {
                return 1;
            }else {
                return o1.compareTo(o2);
            }
             
        }
         
    }
     
}