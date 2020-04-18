import java.util.Scanner;

public class Soultion_d3_1206_1일차 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++) {
			
			int horizon_number = sc.nextInt();
			
			// 처음 0 두개 흘리기
			sc.nextInt();
			sc.nextInt();

			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			int num5 = 0;
			int count = 0;
			
			int view_able_cnt = 0;
			
			
			for(int  j=0; j<horizon_number-7; j++) {
				//처음 앞에 두개 입력받아 비교
				//num1이 기준
				if(j == 0) {
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					num3 = sc.nextInt();
					
					count += 3;
//					System.out.printf("%d %d %d\n",num1,num2,num3);
					//계산
					if(num1 > num2 && num1 > num3) {
						view_able_cnt += (num1 - Math.max(num2, num3));
//						System.out.println(view_able_cnt);
					}
					
					//num2가 기준
				}else if(j == 1) {
					num4 = sc.nextInt();
//					System.out.printf("%d %d %d %d\n",num1,num2,num3,num4);
					//계산
					if(num2 > num1 && num2 > num3 && num2 > num4) {
						view_able_cnt +=  (num2 - max(num1,num3,num4));
//						System.out.println(view_able_cnt);
					}
					
					num1 = num2;
					num2 = num3;
					num3 = num4;
					num4 = sc.nextInt();
					
					count += 2;
				}//처음과 마지막을 제외한 전부
				else {
					num5 = sc.nextInt();
//					System.out.printf("%d %d %d %d %d\n",num1,num2,num3,num4,num5);
					//계산
					if(num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5) {
						view_able_cnt +=  (num3 - max(num1,num2,num4,num5));
//						System.out.println(view_able_cnt);
					}
					
					num1 = num2;
					num2 = num3;
					num3 = num4;
					num4 = num5;
					
					count += 1;
				}
				
				
				if( j== horizon_number-8) {

//					System.out.printf("%d %d %d %d\n",num2,num3,num4,num5);
					
					if(num3 > num1 && num3 > num2 && num3 > num4) {
						view_able_cnt +=  (num3 - max(num1, num2, num4));
//						System.out.println(view_able_cnt);
					}
//					System.out.printf("%d %d %d\n",num3,num4,num5);
					//계산
					if(num4 > num2 && num4 > num3) {
						view_able_cnt +=  (num4 - Math.max(num2, num3));
//						System.out.println(view_able_cnt);
					}
				}
				
			}
			// 마지막 0 두개 흘리기
			sc.nextInt();
			sc.nextInt();
			
			
			System.out.printf("#%d %d\n",i,view_able_cnt);
//			System.out.println("카운트 : "+count);
			
		}
		
		
		
	}
	
	
	public static int max(int a,int b,int c) {
		int[] arr = {a,b,c};
		int max = 0;
		for(int i=0; i<3; i++) {
			if(arr[i]>=max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public static int max(int a,int b,int c,int d) {
		int[] arr = {a,b,c,d};
		int max = 0;
		for(int i=0; i<4; i++) {
			if(arr[i]>=max) {
				max = arr[i];
			}
		}
		
		return max;
	}

}
