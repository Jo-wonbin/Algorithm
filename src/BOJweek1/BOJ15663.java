package BOJweek1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15663 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, temp, temp1, temp2;
	
	static int list[];
	static int copy[];
	static boolean check[];
	
	static void dfs(int cnt) throws IOException {
		
		if(cnt == m) {
			
			for(int i=0; i<m; i++) {
				
					bw.write(copy[i]+" ");
				
			}
			
				bw.write("\n");
			return;
		}
		
		int before = 0; // 비교값 생성
		
		for(int i=1; i<=n; i++) {
			
			if(!check[i] && (i == 0 || before != list[i-1])) {// 중복이거나 다시 반복 이전의 값이 반복되지 않으면 통과
				
				
					before = list[i-1];
					check[i] = true; // 방문한 배열을 중복처리
				
					temp2 = list[i-1];
					copy[cnt] = temp2; // 숫자를  list 배열에 넣음 cnt = 0일 때 첫번째 배열에 넣을 문자처리
				
				//check[i]=false; // 같은 숫자 들어갈 수 있게 함
				
					dfs(cnt+1); // 
				
					check[i] = false;
				
				
			}
		
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String a[] = br.readLine().split(" ",2);
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		list  = new int[n];
		String b[] = br.readLine().split(" ");
		
		for(int i=0; i<b.length; i++) {
			temp1 = Integer.parseInt(b[i]);
			list[i] = temp1;
		}
		
		
		copy = new int[n];
		
		
		for(int i=0; i<list.length-1; i++) {         // 버블정렬
			for(int j=i+1; j<list.length; j++) {
				if(list[i] > list[j]) {
					temp = list[i];
					list[i]=list[j];
					list[j]=temp;
					
				}
			}
			
		}

		
		check = new boolean[9];
		//list = new int [9];
		dfs(0);
		
		br.close();
		bw.flush();
		bw.close();
	}

}

