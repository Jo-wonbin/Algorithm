package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1436 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int evil = 666;
		int count = 0;
		
		while(count != n) {
			String a = "" + evil;
			
			if(a.contains("666")) {
				count++;
			}
			evil++;
		}
		
		bw.write(evil-1+"");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
