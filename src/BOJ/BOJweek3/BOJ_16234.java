package BOJ.BOJweek3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	static Queue<Point> q = new LinkedList<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, L, R, sum, count = 0, a;
	static int cnt;
	static int idx;
	static int[][]map;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		check = new int[n+1][n+1];
		
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		while(true) {
			idx = 1;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(check[i][j] == 0) {
						sum = 0;
						bfs(i,j);
					}
				}
			}
			
			if(idx > n*n)
				break;
			count+=1;
			check = new int [n+1][n+1];				
		}
		
		
		bw.write(count+"");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

	static void bfs(int x, int y) throws IOException {
		q.offer(new Point(x,y));
		check[x][y] = idx;
		sum+=map[x][y];
		cnt = 1;
        while(!q.isEmpty())  {
        	
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            int nx = now.x+dx[h];    // �����¿� �˻�
            int ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > n)  // ���� ������ ���� �ʰ�
            	continue;								
            if(Math.abs(map[nx][ny]-map[now.x][now.y]) < L)
            	continue;
            if(Math.abs(map[nx][ny]-map[now.x][now.y]) > R)     
            	continue;
            if(check[nx][ny] > 0)
             	continue;
            cnt+=1;
            q.offer(new Point(nx,ny));         // ť�� �ش� ��ǥ�� ť�� ����
            check[nx][ny] = idx; 				// �ش� ��ǥ �ߺ� üũ		
            sum += map[nx][ny];
            }
        }
        sum = sum / cnt;
        for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(check[i][j] == idx) {
					map[i][j] = sum;
				}
			}
		}
        
        idx++;

 
	}
	
	
//	static void sumA() throws IOException {
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				if(check[i][j] == idx) {
//					sum = sum + map[i][j];
//					
//				}
//			}
//		}
//        sum = sum / cnt;
//
//        for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				if(check[i][j] == idx) {
//					map[i][j] = sum;
//				}
//			}
//		}
//        
//	}
}

