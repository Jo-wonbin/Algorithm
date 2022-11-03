package BOJ.BOJweek1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15649 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int list[];
	static boolean check[];
	
	static void dfs(int cnt) throws IOException {
		
		if(cnt == m) {
			
			for(int i=0; i<m; i++) {
				
					bw.write(list[i]+"");
					if(i !=m-1) {
						bw.write(" ");
					}
				
			}
			
			bw.write("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			
			if(check[i]) continue; // �ߺ��̸� �ٽ� �ݺ�
				
				check[i] = true; // �湮�� �迭ó��
				list[cnt] = i; // ���ڸ�  list �迭�� ����
				dfs(cnt+1); // �ٽ� dfs ����
				check[i] = false;
			
		
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String a[] = br.readLine().split(" ",2);
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		
		check = new boolean[9];
		list = new int [9];
		dfs(0);
		
		bw.flush();
		bw.close();
	}

}

