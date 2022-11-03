package BOJ.BOJweek2;
import java.io.*;
import java.util.*;

public class BOJ_1260 {

	static int n;
	static ArrayList<Integer>[] list;
	static boolean check[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		int a,b;
		
		list = new ArrayList[n+1]; // �迭�� �����ϴ� �迭�� ����.
		
		for(int i=1; i<n+1; i++) {
			
			list[i] = new ArrayList<Integer>(); //�迭 �ȿ� �迭 ����
			
		}
		
		for(int i=0; i<m; i++) {
			
			a = sc.nextInt();
			b = sc.nextInt();
			
			list[a].add(b); // a ������ ��� b�� ����
			list[b].add(a); // b ������ ��� a�� ����
			
		}
		
		for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

		
		check = new boolean [n+1]; // �ߺ��� üũ�ϴ� �迭 �ʱ�ȭ
		dfs(v);
		bw.write("\n");
		
		check = new boolean [n+1]; // �ߺ��� üũ�ϴ� �迭 �ʱ�ȭ
		bfs(v);
		bw.write("\n");
		
		sc.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v) throws IOException {
	
		check[v] = true; // �湮�� �迭�� �ߺ����� ����
		
		bw.write(v+" "); // ������ �� ���
		
		for(int y : list[v]) { // list[v]�� ���� y�� ������ �� y��°�� �ߺ��� �ƴϸ� �ݺ�
			
			if(!check[y]) {
				dfs(y);
			}
				
			
		}
		
	}
	
	
	static void bfs(int v) throws IOException {
		
		Queue<Integer> queue = new LinkedList<Integer>(); // ť ����
		queue.add(v);         // ť�� ������ ���� v�� ����
		check[v] = true;      // ������ �� �湮�ߴٰ� ó������.
		
		while(!queue.isEmpty()) { // ť�� ������� ������ ����
			int x = queue.poll();  // x�� ù��° ť�� ���� �ְ� ť�� ����
			bw.write(x+" ");         // x�� ���
			for(int y : list[x]) {  // y�� list[x] ���� ���������� �Է�
				
				if (!check[y]) {     // �ߺ��� �ƴϸ�
					
					check[y] = true;  // �ٳణ ��忡 �ߺ�ó���ϰ�
					queue.add(y);      //ť�� y�� ����
					
				}
				
			}
		}
		
	}

}
