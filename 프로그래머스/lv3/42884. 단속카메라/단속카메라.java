import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
           return o1[1] - o2[1];
        });
        
        int value = -30001;
        
        for(int i=0; i<routes.length; i++){
            if(value < routes[i][0]){
                answer++;
                value = routes[i][1];
            }
        }
        
        return answer;
    }
}