package BOJ.BOJweek2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {

	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][]map; 
	static boolean [][]check;
	static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int n,m;
    static ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String a[] = br.readLine().split(" ");
	    n = Integer.parseInt(a[0]);
	    m = Integer.parseInt(a[1]);
	    
	    map = new int[n+1][m+1];
	    check = new boolean[n+1][m+1];
	    
	    for(int i=1; i <= n;i++) {
            String b = br.readLine();
            
            for(int j=1; j <= m;j++) 
                map[i][j] = Integer.parseInt(b.substring(j-1,j));
        }
	    
	    bfs(1,1);             
        
        bw.write(map[n][m]+"");     
        
        br.close();
        bw.flush();
        bw.close();
	}
	
	static void bfs(int x, int y) {
		
		    
        q.offer(new Point(x,y));     // ť���ٰ� Point ��ǥ�� �ּ� ����
        check[x][y] = true;
		
        while(!q.isEmpty() && x != n  && y!= m)  {
        	
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            int nx = now.x+dx[h];    // �����¿� �˻�
            int ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m)  // ���� ������ ���� �ʰ�
            	continue;								
            if(map[nx][ny] == 0)       // ������ 1�̰� �ߺ��� �ƴϸ�
            	continue;
            if(check[nx][ny])
             	continue;
            											
            q.offer(new Point(nx,ny));         // ť�� �ش� ��ǥ�� ť�� ����
            check[nx][ny] = true; 				// �ش� ��ǥ �ߺ� üũ
            						
            map[nx][ny] = map[now.x][now.y]+1;       //������ ��ǥ�� ���� ���� ��ǥ+1 ����.
            }
        }
        
        
	}

}
