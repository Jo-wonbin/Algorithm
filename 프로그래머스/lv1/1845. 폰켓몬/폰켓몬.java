import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = nums.length/2;
        
        Set<Integer> set = new HashSet<>();
        for(int temp : nums){
            set.add(temp);
        }
        
        if(set.size() >= N){
            answer = N;
        }else{
            answer = set.size();
        }
        
        return answer;
    }
}