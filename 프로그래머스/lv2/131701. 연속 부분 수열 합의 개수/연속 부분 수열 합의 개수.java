import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int size = elements.length;
        for(int i = 1; i <= size; i++){
            int index = 0;
            while(true){
                if(index == size)
                    break;
                int sum = 0;
                int cnt = 0;
                while(true){
                    if(cnt == i)
                        break;
                    sum += elements[(index + cnt) % size];
                    cnt++;
                }
                index++;
                set.add(sum);
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}