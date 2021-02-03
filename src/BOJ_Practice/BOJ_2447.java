package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2447 {

	static char a[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		a = new char[n+1][n+1];
		
		for(int i=0; i<n; i++ ) {
			for(int j=0; j<n; j++) {
				a[i][j] = ' ';
			}
		}
		
		star(n, 0, 0);
		for(int i=0; i<n; i++ ) {
			for(int j=0; j<n; j++) {
				sb.append(a[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void star(int n, int x, int y) {
		
		if(n==1) {
			a[x][y] = '*';       // n=1이면 그 위치에 *넣고 반환
			return;
		}
		n/=3;      // n은 n/3
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) continue;
					star(n, i*n+x, j*n+y);
				
			}
		}
	}
	
}
