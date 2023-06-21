import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int temp : tangerine){
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        Collections.reverse(list);
        
        for(int temp : list){
            if(k - temp <= 0){
                answer++;
                break;
            }
            k -= temp;
            answer++;
        }
        
        return answer;
    }
}