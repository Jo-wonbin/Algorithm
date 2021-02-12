package BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int s;
	static int cnt, result;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a = br.readLine();
		s = Integer.parseInt(a);
		
		check = new boolean[2002][2002];
	//	check = new boolean[s+1];
		
		bfs(s);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static void bfs(int end) throws IOException {
		
		Queue<node> q = new LinkedList<node>();
		q.offer(new node(1,0,0));
		check[1][0] = true;
		
		while(!q.isEmpty()) {
			
			node copy = q.poll();
			
			if(copy.x >= end) {
				bw.write(copy.z+"");
				break;
			}
			
			q.offer(new node(copy.x, copy.x, copy.z+1)); // ȭ�� ���� �� Ŭ�� ����
			
			if(!check[copy.x+copy.y][copy.y] && copy.y != 0 && copy.x+copy.y <= end) { // Ŭ�����ִ� �� ȭ�鿡 ����
				q.offer(new node(copy.x+copy.y, copy.y, copy.z+1));
				check[copy.x+copy.y][copy.y]= true; 
			}
			
			if(!check[copy.x-1][copy.y] && copy.x-1 >= 1) { // ȭ�� �� 1����
				q.offer(new node(copy.x-1, copy.y, copy.z+1));
				check[copy.x-1][copy.y]= true; 
			}
			
		}
		
	}

}

class node{
	int x;
	int y;
	int z;
	node (int scr, int clp, int cnt){
		this.x = scr;
		this.y = clp;
		this.z = cnt;
	}
}