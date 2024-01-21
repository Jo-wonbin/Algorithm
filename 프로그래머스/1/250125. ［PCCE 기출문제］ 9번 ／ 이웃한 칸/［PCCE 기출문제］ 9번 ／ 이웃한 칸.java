class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        String nowColor = board[h][w];
        
        for(int i=0; i<4; i++){
            int nx = h+dx[i];
            int ny = w+dy[i];
            
            if(nx < 0 || ny <0 || nx >board.length-1 || ny > board[0].length-1)
                continue;
            if(nowColor.equals(board[nx][ny])){
                answer++;
            }
        }
        
        return answer;
    }
}