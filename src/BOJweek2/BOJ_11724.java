package BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11724 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, u, v;
	static boolean check[];
	static int list[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a[]= br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		
		list = new int[n+1][n+1];      // 접점과 노드의 값을 담을 2차원 배열 생성
		check = new boolean[n+1];      // 노드 중복 체크할 배열
		
		for(int i=0; i<m; i++) {
			
			String b[] = br.readLine().split(" ");
			v = Integer.parseInt(b[0]);
			u = Integer.parseInt(b[1]);
			
			list[v][u]=list[u][v]=1;       // 접점과 노드가 있는 배열에 1의 값을 넣어줌.
			
		}
		
		int cnt = 1;      
		for(int i=1; i<=n; i++) {
			if(check[i] == false) { // 중복이 아니면
				dfs(i,cnt);     // 탐색 1부터 n번째 노드까지 탐색하는데 1의 노드가 2와 5에 연결되었을 때 2와 5번 접점은 빼고 탐색
				cnt++;           // 카운트+1
			}
		}

		bw.write(cnt-1+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static void dfs(int v, int cnt) throws IOException {
		
		check[v] = true; // 방문한 배열을 중복으로 선언
			
		for(int i=1; i<n+1; i++) {
			if(list[v][i] == 1 && check[i] == false) {      // 접점에 노드가 있고 중복이 아니라면
				dfs(i,cnt);     // 탐색
			}
			
		}
		
	}
	
	
}
