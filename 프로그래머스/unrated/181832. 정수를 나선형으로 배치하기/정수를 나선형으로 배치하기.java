class Solution {
    
    static int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[n][n];
        find(0, 0, 1, 0, n*n, n);
        return answer;
    }
    
    static void find(int x, int y, int index, int dir, int max, int n){
        if(index == max+1 || answer[x][y] > 0){
            return;
        }
        
        answer[x][y] = index;

        if(dir == 0){
            if(y+1 > n-1 || answer[x][y+1] > 0){
                dir = (dir + 1) % 4;
                x++;
            }else
                y++;
        }else if(dir == 1){
            if(x+1 > n-1 || answer[x+1][y] > 0){
                dir = (dir + 1) % 4;
                y--;
            }else
                x++;
        }else if(dir == 2){
            if(y-1 < 0 || answer[x][y-1] > 0){
                dir = (dir + 1) % 4;
                x--;
            }else
                y--;
        }else if(dir == 3){
            if(x-1 < 0 || answer[x-1][y] > 0){
                dir = (dir + 1) % 4;
                y++;                
            }else
                x--;
        }
        find(x, y, index+1, dir, max, n);
    }
}