package BojProblem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15651 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int list[];
	static boolean check[];
	
	static void dfs(int cnt, int num) throws IOException {
		
		if(cnt == m) {
			
			for(int i=0; i<m; i++) {
				
					bw.write(list[i]+" ");
					
			}
			
			bw.write("\n");
			return;
		}
		
		for(int i=num; i<=n; i++) {
			
			if(!check[i]) {// 중복이면 다시 반복
				
				check[i] = true; // 방문한 배열을 중복처리
				
				list[cnt] = i; // 숫자를  list 배열에 넣음 cnt = 0일 때 첫번째 배열에 넣을 문자처리
				check[i]=false; // 중복을 없애줌
				dfs(cnt+1, 1); // 다시 dfs 시작하는 데 i=1부터 반복
				
				check[i] = false;
				
			}
		
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String a[] = br.readLine().split(" ",2);
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		
		check = new boolean[9];
		list = new int [9];
		dfs(0,1);
		
		bw.flush();
		bw.close();
	}

}

