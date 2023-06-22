import java.util.*;

class Solution {
    
    static class Point{
        int x, y;
        
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            String temp = maps[i];
            for(int j=0; j<temp.length(); j++){
                map[i][j] = temp.charAt(j);
            }
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(visited[i][j])
                    continue;
                if(map[i][j] == 'X')
                    continue;
                
                visited[i][j] = true;
                q.add(new Point(i, j));
                list.add(bfs(map.length, map[0].length, map[i][j] - '0'));
                q.clear();
            }
        }

        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            Collections.sort(list);
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
    
    public int bfs(int xLimit, int yLimit, int point){
        int sum = point;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for(int h = 0; h < 4; h++){
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];
                
                if(nx < 0 || ny < 0 || nx > xLimit-1 || ny > yLimit-1)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(map[nx][ny] == 'X')
                    continue;
                
                visited[nx][ny] = true;
                sum += (map[nx][ny] - '0');
                q.add(new Point(nx, ny));
            }
        }
        
        return sum;
    }
}