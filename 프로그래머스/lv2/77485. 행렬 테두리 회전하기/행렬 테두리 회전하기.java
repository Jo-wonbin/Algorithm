import java.util.*;

class Solution {
    
    static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        map = new int[rows+1][columns+1];
        int cnt = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = cnt++;
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<queries.length; i++){
            list.add(rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]));
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public int rotate(int sx, int sy, int ex, int ey){
        int min = Integer.MAX_VALUE;
        Deque<Integer> list = new ArrayDeque<>();
        
        for(int i=sy; i <= ey; i++){   
            min = Math.min(min, map[sx][i]);
            list.addLast(map[sx][i]);
        }
        for(int i=sx+1; i <= ex; i++){
            min = Math.min(min, map[i][ey]);
            list.addLast(map[i][ey]);
        }
        for(int i=ey-1; i >= sy; i--){
            min = Math.min(min, map[ex][i]);
            list.addLast(map[ex][i]);
        }
        for(int i=ex-1; i >= sx+1; i--){
            min = Math.min(min, map[i][sy]);
            list.addLast(map[i][sy]);
        }
        
        int temp = list.pollLast();
        list.addFirst(temp);
        
        for(int i=sy; i <= ey; i++){  
            map[sx][i] = list.poll();
        }
        for(int i=sx+1; i <= ex; i++){           
            map[i][ey] = list.poll();
        }
        for(int i=ey-1; i >= sy; i--){           
            map[ex][i] = list.poll();
        }
        for(int i=ex-1; i >= sx+1; i--){           
            map[i][sy] = list.poll();
        }
        
        return min;
    }
}