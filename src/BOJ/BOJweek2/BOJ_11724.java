package BOJ.BOJweek2;

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
		
		list = new int[n+1][n+1];      // ������ ����� ���� ���� 2���� �迭 ����
		check = new boolean[n+1];      // ��� �ߺ� üũ�� �迭
		
		for(int i=0; i<m; i++) {
			
			String b[] = br.readLine().split(" ");
			v = Integer.parseInt(b[0]);
			u = Integer.parseInt(b[1]);
			
			list[v][u]=list[u][v]=1;       // ������ ��尡 �ִ� �迭�� 1�� ���� �־���.
			
		}
		
		int cnt = 1;      
		for(int i=1; i<=n; i++) {
			if(check[i] == false) { // �ߺ��� �ƴϸ�
				dfs(i,cnt);     // Ž�� 1���� n��° ������ Ž���ϴµ� 1�� ��尡 2�� 5�� ����Ǿ��� �� 2�� 5�� ������ ���� Ž��
				cnt++;           // ī��Ʈ+1
			}
		}

		bw.write(cnt-1+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static void dfs(int v, int cnt) throws IOException {
		
		check[v] = true; // �湮�� �迭�� �ߺ����� ����
			
		for(int i=1; i<n+1; i++) {
			if(list[v][i] == 1 && check[i] == false) {      // ������ ��尡 �ְ� �ߺ��� �ƴ϶��
				dfs(i,cnt);     // Ž��
			}
			
		}
		
	}
	
	
}
