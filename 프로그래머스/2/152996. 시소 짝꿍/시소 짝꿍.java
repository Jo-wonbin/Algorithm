import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int value : weights){
            double a = value*1.0;
            double b = (value*2.0)/3.0;
            double c = (value*1.0)/2.0;
            double d = (value*3.0)/4.0;
            if(map.containsKey(a)) answer+=map.get(a);
            if(map.containsKey(b)) answer+=map.get(b);
            if(map.containsKey(c)) answer+=map.get(c);
            if(map.containsKey(d)) answer+=map.get(d);
            map.put((value*1.0), map.getOrDefault((value*1.0), 0)+1);
        }
        
        return answer;
    }
}