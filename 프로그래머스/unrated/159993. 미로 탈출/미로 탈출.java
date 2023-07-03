import java.util.*;

class Solution {
    
    static class Point{
        int x, y, depth;
        
        Point(int x, int y, int depth){
            this.x=x;
            this.y=y;
            this.depth = depth;
        }
    }
    
    static char map[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int result;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        result = 0;
        int N = maps.length;
        int M = maps[0].length();
        map = new char[N][M];
        
        int x = 0;
        int y = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'L'){
                    x = i;
                    y = j;
                }
            }
        }
        
        if(bfs(x, y, true, N, M) && bfs(x, y, false, N, M))
            answer = result;
        else
            return -1;
        
        return answer;
    }
    
    public boolean bfs(int x, int y, boolean flag, int N, int M){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        boolean visited[][] = new boolean[N][M];
        visited[x][y] = true;
        while(!q.isEmpty()){
            
            Point now = q.poll();
            
            if(flag && map[now.x][now.y] == 'S'){
                result += now.depth;
                return true;
            }
            if(!flag && map[now.x][now.y] == 'E'){
                result += now.depth;
                return true;
            }
            
            for(int h=0; h<4; h++){
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];
                
                if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(map[nx][ny] ==  'X')
                    continue;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny, now.depth+1));
            }
            
        }
        return false;
    }
}