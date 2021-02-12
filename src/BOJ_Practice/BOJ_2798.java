package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2798 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, sum;
	static int[]list;
	static boolean[] check;
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new int[n+1];
		check = new boolean[n+1];
		
		String a[] = br.readLine().split(" ");
		for(int i=1; i<=n; i++) {
			list[i] = Integer.parseInt(a[i-1]);
		}
		
		for(int i=1; i<=n; i++) {
				check[i] = true;
				dfs(i, 0, list[i]);
				check[i] = false;
			
		}
		
//		Collections.sort(al);
//		int c = al.size();
		bw.write(sum+"");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int start, int count, int plus) {

		if(plus > m) {
			return;
		}
		
		if(count == 2) {
			sum = Math.max(sum, plus);
			return;
		}
		for(int i=start; i<=n; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			dfs(i+1, count+1, plus+list[i]);
			check[i] = false;
		}
	}
}
