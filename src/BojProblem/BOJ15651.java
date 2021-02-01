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
			
			if(!check[i]) {// �ߺ��̸� �ٽ� �ݺ�
				
				check[i] = true; // �湮�� �迭�� �ߺ�ó��
				
				list[cnt] = i; // ���ڸ�  list �迭�� ���� cnt = 0�� �� ù��° �迭�� ���� ����ó��
				check[i]=false; // �ߺ��� ������
				dfs(cnt+1, 1); // �ٽ� dfs �����ϴ� �� i=1���� �ݺ�
				
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

