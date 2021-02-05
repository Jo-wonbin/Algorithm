package BOJ_Practice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class BOJ_2667_bfs {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Point> q = new LinkedList<>();
    static int[][]map; 
    static boolean [][]visited;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static ArrayList<Integer> al = new ArrayList<Integer>();
    static int N;
    
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        int call_num = 0;
        String b = br.readLine();
        N = Integer.parseInt(b);
        
        map = new int[N][N];
        visited = new boolean[N][N];

        
        for(int i=0;i<N;i++) {
            String a = br.readLine();
            
            for(int j=0;j<N;j++) 
                map[i][j] = a.charAt(j) - '0';
        }
 
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) 
                if(map[i][j] == 1 && !visited[i][j]) { // 지도에 1이 있고 중복이 아니면 
                    BFS(i,j);          // BFS 시작
                    call_num++;        // BFS가 시작될 때마다 1증가
                }
        
        bw.write(call_num+ "\n");   // 단지 수 출력
        
        Collections.sort(al);             // 아파트 수 오름차순 정렬
        for(int i=0;i<al.size();i++)
            bw.write(al.get(i)+ "\n");      // 아파트 수 출력
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static void BFS(int i, int j) 
    {
        int nx,ny;
        int local_cnt = 1;    // 아파트 수 1부터 시작
        q.offer(new Point(i,j));     // 큐에다가 Point 좌표의 주소 저장
        visited[i][j] = true;     // 중복 체크
        
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // 큐값을 now에 저장하고 삭제
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // 상하좌우 검사
            ny = now.y+dy[h];
            
            if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1)
            	continue;											// 지도 범위를 넘지 않고
            if(map[nx][ny] == 0)
            	continue;
            if(visited[nx][ny])
             	continue;
            											// 지도가 1이고 중복이 아니면
            q.offer(new Point(nx,ny));         // 큐에 해당 좌표을 큐에 넣음
            visited[nx][ny] = true; 				// 해당 좌표 중복 체크
            local_cnt++;						//아파트 수 1증가
            
                
            }
        }
        al.add(local_cnt);				// 동적 배열에 아파트 수 넣음.
    }
}
