package BOJ_Practice;

import java.util.Scanner;

public class BOJ_2447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		star(n, n/3);
	}

	static void star(int n, int cnt) {
		
	//	if( )
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i <= ((n+1)/2) + (cnt/2) && i >= ((n+1)/2) - (cnt/2))
				System.out.print("*");
			}
			System.out.println();
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				
//		
//				
//			}
//		}
	}
	
}
