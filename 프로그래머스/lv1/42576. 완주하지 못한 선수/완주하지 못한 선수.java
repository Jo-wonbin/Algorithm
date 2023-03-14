import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String comp : completion){
            if(map.containsKey(comp)){
                map.replace(comp, map.get(comp)+1);
            }else{
                map.put(comp, 1);
            }
        }
        
        for(String part : participant){
            if(!map.containsKey(part)){
                return part;
            }else{
                int count = map.get(part);
                if(count >= 1){
                    map.replace(part, count-1);
                }else{
                    return part;
                }
            }
        }
        
        return answer;
    }
}