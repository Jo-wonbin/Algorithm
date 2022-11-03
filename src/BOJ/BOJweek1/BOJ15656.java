package BOJ.BOJweek1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15656 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, temp, temp1, temp2;
	
	static int list[];
	static int copy[];
	static boolean check[];
	
	static void dfs(int cnt, int num) throws IOException {
		
		if(cnt == m) {
			
			for(int i=0; i<m; i++) {
				
					bw.write(copy[i]+" ");
				
			}
			
				bw.write("\n");
			return;
		}
		
		for(int i=num; i<= n; i++) {
			
			if(!check[i]) {// �ߺ��̸� �ٽ� �ݺ�
				
				check[i] = true; // �湮�� �迭�� �ߺ�ó��
				temp2 = list[i-1];
				copy[cnt] = temp2; // ���ڸ�  list �迭�� ���� cnt = 0�� �� ù��° �迭�� ���� ����ó��
				
				check[i]=false; // ���� ���� �� �� �ְ� ��
				
				dfs(cnt+1,1); // 
				
				//check[i] = false;
				
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
		dfs(0,1);
		
		bw.flush();
		bw.close();
	}

}

