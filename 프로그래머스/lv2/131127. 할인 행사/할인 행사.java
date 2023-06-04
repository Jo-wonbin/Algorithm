import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<discount.length-9; i++){
            
            for(int j=0; j<want.length; j++){               
                map.put(want[j], number[j]);
            }
            for(int j=i; j<i+10; j++){
                String temp = discount[j];
                if(map.containsKey(temp)){
                    int size = map.get(temp);
                    if(size > 1){
                        map.replace(temp, size-1);
                    }else{
                        map.remove(temp);
                    }
                }else{
                    break;
                }
            }
            
            if(map.isEmpty()){
                answer++;
            }
            
            map.clear();
        }
        
        
        
        return answer;
    }
}