import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        List<Integer> max = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        
        for(int temp[] : sizes){
            max.add(Math.max(temp[0], temp[1]));
            min.add(Math.min(temp[0], temp[1]));
        }
        
        Collections.sort(max);
        Collections.sort(min);
        
        answer = max.get(sizes.length-1) * min.get(sizes.length-1);
        
        return answer;
    }
}