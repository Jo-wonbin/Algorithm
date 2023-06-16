class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean map[][][] = new boolean[11][11][4];
        
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        
        int x = 5, y = 5; 
        for(int i=0; i<dirs.length(); i++){
            char temp = dirs.charAt(i);
            int dir = -1;
            if(temp == 'L'){
                dir = 0;
            }else if(temp == 'U'){
                dir = 1;
            }else if(temp == 'D'){
                dir = 2;
            }else{
                dir = 3;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || ny < 0 || nx > 10 || ny > 10)
                continue;
            
            if(!map[nx][ny][3-dir] && !map[x][y][dir]){
                answer++;
                map[nx][ny][3-dir] = true;
                map[x][y][dir] = true;
            }

            x = nx;
            y = ny;
        }
        
        return answer;
    }
}