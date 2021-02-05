package BOJweek2;

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
		
		    
        q.offer(new Point(x,y));     // 큐에다가 Point 좌표의 주소 저장
        check[x][y] = true;
		
        while(!q.isEmpty() && x != n  && y!= m)  {
        	
            Point now = q.poll();        // 큐값을 now에 저장하고 삭제
            
            for(int h=0;h<4;h++) {
            int nx = now.x+dx[h];    // 상하좌우 검사
            int ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m)  // 지도 범위를 넘지 않고
            	continue;								
            if(map[nx][ny] == 0)       // 지도가 1이고 중복이 아니면
            	continue;
            if(check[nx][ny])
             	continue;
            											
            q.offer(new Point(nx,ny));         // 큐에 해당 좌표을 큐에 넣음
            check[nx][ny] = true; 				// 해당 좌표 중복 체크
            						
            map[nx][ny] = map[now.x][now.y]+1;       //마지막 좌표의 값을 현재 좌표+1 해줌.
            }
        }
        
        
	}

}
