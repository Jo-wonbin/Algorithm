import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            String x = "" + o1 + o2;
            String y = "" + o2 + o1;
            
            return Integer.parseInt(y) - Integer.parseInt(x);
            
        });
        int zeroCnt = 0;
        for(int temp : numbers){
            if(temp == 0)
                zeroCnt++;
            pq.add(temp);
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        answer = sb.toString();
        if(zeroCnt == numbers.length)
            answer = "0";
        
        return answer;
    }
}