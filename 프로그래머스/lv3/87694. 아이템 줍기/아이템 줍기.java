import java.util.*;

class Solution {
    
    static class Point{
        int x,y,depth;
        
        Point(int x, int y, int depth){
            this.x=x;
            this.y=y;
            this.depth=depth;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int dx[] = {0,0,-1,1, -1, -1, 1, 1};
    static int dy[] = {-1,1,0,0, -1, 1, -1, 1};
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        visited = new boolean[101][101];
        
        result = 0;
        
        for(int i=0; i<rectangle.length; i++){
            int underX = rectangle[i][0] * 2;
            int underY = rectangle[i][1] * 2;
            int upX = rectangle[i][2] * 2;
            int upY = rectangle[i][3] * 2;
            
            for(int j=underX; j <= upX; j++){
                for(int h=underY; h<=upY; h++){
                    map[j][h] = 1;
                }
            }
        }
        
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j] == 1){
                    for(int h=0; h<8; h++){
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        
                        if(nx < 0 || ny < 0 | nx > 100 || ny > 100 || map[nx][ny] == 0){
                            map[i][j] = 2;
                        }
                    }
                }
            }
        }
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        answer = result / 2;
        return answer;
    }
    
    public void bfs(int cx, int cy, int ix, int iy){
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(cx, cy, 0));
        visited[cx][cy] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            if(now.x == ix && now.y == iy){
                result = now.depth;
                return;
            }
            
            for(int h=0; h<4; h++){
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(map[nx][ny] < 2)
                    continue;
                
                q.add(new Point(nx, ny, now.depth+1));
                visited[nx][ny] = true;
            }
        }
    }
}