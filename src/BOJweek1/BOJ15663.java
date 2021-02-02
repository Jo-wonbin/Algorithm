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
		
		int before = 0; // �񱳰� ����
		
		for(int i=1; i<=n; i++) {
			
			if(!check[i] && (i == 0 || before != list[i-1])) {// �ߺ��̰ų� �ٽ� �ݺ� ������ ���� �ݺ����� ������ ���
				
				
					before = list[i-1];
					check[i] = true; // �湮�� �迭�� �ߺ�ó��
				
					temp2 = list[i-1];
					copy[cnt] = temp2; // ���ڸ�  list �迭�� ���� cnt = 0�� �� ù��° �迭�� ���� ����ó��
				
				//check[i]=false; // ���� ���� �� �� �ְ� ��
				
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
		
		
		for(int i=0; i<list.length-1; i++) {         // ��������
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

