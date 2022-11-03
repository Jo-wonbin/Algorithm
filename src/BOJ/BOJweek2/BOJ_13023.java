package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {

	static int n, k, cnt;
	static ArrayList<Integer>[] al;
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean check[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		al = new ArrayList[n];
		int a,b;
		
		for(int i=0; i<n; i++) {
			
			al[i] = new ArrayList<Integer>(); //�迭 �ȿ� �迭 ����
			
		}
		
		for(int i=0; i<k; i++) {
			
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st1.nextToken());
			b = Integer.parseInt(st1.nextToken());
			
			al[a].add(b); // a ������ ��� b�� ����
			al[b].add(a); // b ������ ��� a�� ����
			
		}
		
		check = new boolean [n]; // �ߺ��� üũ�ϴ� �迭 �ʱ�ȭ
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				cnt = 1;
				dfs(i,cnt);
				check[i] = false;
				if(arr.size() > 1)
					break;
			}
		}

		arr.add(0);

		bw.write(arr.get(0)+"");
		
		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int count) throws IOException {
		if(count == 5) {
			arr.add(1);
			return;
		}
		check[x] = true;
		for(int y : al[x]) { // list[v]�� ���� y�� ������ �� y��°�� �ߺ��� �ƴϸ� �ݺ�
			if(!check[y]) {
				check[y] = true;
				dfs(y, count+1);
				check[y] = false;
			}
				
			
		}

		
	}
}
