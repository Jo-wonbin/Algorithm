import java.util.*;

class Solution {
    
    static class Point{
        int start, end;
        
        Point(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        Map<Integer, Point> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int n = sequence.length;
        int sum = sequence[end];
        while(true){
            
            if(sum == k){
                if(!map.containsKey(end - start))
                    map.put(end - start, new Point(start, end));
            }
            
            if(start == n && end == n)
                break;
            
            if(sum <= k && end < n){
                end++;
                if(end < n)
                    sum += sequence[end];
            }else{
                if(start < n)
                    sum -= sequence[start];
                start++;
            }
        }
        
        int count = 0;
        while(true){
            if(map.containsKey(count)){
                Point now = map.get(count);
                answer[0] = now.start;
                answer[1] = now.end;
                break;
            }
            count++;
        }
        
        
        return answer;
    }
}