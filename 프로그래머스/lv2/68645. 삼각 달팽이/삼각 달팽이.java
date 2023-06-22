import java.util.*;

class Solution {
    
    public int[] solution(int n) {
        int[] answer = {};
        
        int map[][] = new int[n][n];
        int dx[] = {1, 0, -1};
        int dy[] = {0, 1, -1};
        
        int limit = 0;
        for(int i=1; i<=n; i++){
            limit += i;
        }

        int x = 0;
        int y = 0;
        int count = 1;
        int dir = 0;
        
        while(count < limit + 1){
            map[x][y] = count;
            
            // 다음에 갈 좌표
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 다음에 갈 좌표에 갈 수 없으면 방향과 좌표 갱신
            if(dir == 0){
                if(nx > map.length - 1 || map[nx][ny] != 0){
                    dir = (dir+1) % 3;
                }
            }else if(dir == 1){
                if(ny > map.length - 1 || map[nx][ny] != 0){
                    dir = (dir+1) % 3;
                }
            }else if(dir == 2){
                if(nx < 0 || ny < 0 || map[nx][ny] != 0){
                    dir = (dir+1) % 3;
                }
            }
            x += dx[dir];
            y += dy[dir];
            
            count++;
        }
        
        
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<cnt; j++){
                list.add(map[i][j]);
            }
            cnt++;
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
}