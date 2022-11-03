package BOJ.BOJ_Practice;

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
                if(map[i][j] == 1 && !visited[i][j]) { // ������ 1�� �ְ� �ߺ��� �ƴϸ� 
                    BFS(i,j);          // BFS ����
                    call_num++;        // BFS�� ���۵� ������ 1����
                }
        
        bw.write(call_num+ "\n");   // ���� �� ���
        
        Collections.sort(al);             // ����Ʈ �� �������� ����
        for(int i=0;i<al.size();i++)
            bw.write(al.get(i)+ "\n");      // ����Ʈ �� ���
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static void BFS(int i, int j) 
    {
        int nx,ny;
        int local_cnt = 1;    // ����Ʈ �� 1���� ����
        q.offer(new Point(i,j));     // ť���ٰ� Point ��ǥ�� �ּ� ����
        visited[i][j] = true;     // �ߺ� üũ
        
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // �����¿� �˻�
            ny = now.y+dy[h];
            
            if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1)
            	continue;											// ���� ������ ���� �ʰ�
            if(map[nx][ny] == 0)
            	continue;
            if(visited[nx][ny])
             	continue;
            											// ������ 1�̰� �ߺ��� �ƴϸ�
            q.offer(new Point(nx,ny));         // ť�� �ش� ��ǥ�� ť�� ����
            visited[nx][ny] = true; 				// �ش� ��ǥ �ߺ� üũ
            local_cnt++;						//����Ʈ �� 1����
            
                
            }
        }
        al.add(local_cnt);				// ���� �迭�� ����Ʈ �� ����.
    }
}
