import java.util.*;

class Solution {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static boolean visited[][];
    static int[][] map;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    
    public int solution(int[][] land) {
        
        int num = 1;
        visited = new boolean[land.length][land[0].length];
        map = new int[land.length][land[0].length];
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(visited[i][j])
                    continue;
                if(land[i][j] == 1){
                    hashMap.put(num, bfs(land, i, j, num));
                    num++;
                }
            }
        }
        int max = 0;
        for(int i=0; i<land[0].length; i++){
            Set<Integer> set = new HashSet<>();
            int nowValue = 0;
            for(int j=0; j<land.length; j++){
                if(map[j][i] == 0)
                    continue;
                if(set.contains(map[j][i]))
                    continue;
                set.add(map[j][i]);
                nowValue += hashMap.get(map[j][i]);
            }
            max = Math.max(max, nowValue);
        }
        
        
        return max;
    }
    
    public int bfs(int[][] land, int x, int y, int num){
        
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = num;
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for(int h=0; h<4; h++){
                int nx = now.x+dx[h];
                int ny = now.y+dy[h];
                
                if(nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(land[nx][ny] == 0)
                    continue;
                count++;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
                map[nx][ny] = num;
            }
        }
        return count;
    }
}