import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet<>();
        
        String temp = s.substring(1, s.length()-1);
        
        Map<Integer, String> map = new HashMap<>();
        
        int index = 0;
        while(index < temp.length()){
            if(temp.charAt(index) == '{'){
                int count = 0;
                for(int i=index+2; i<temp.length(); i++){
                    if(temp.charAt(i) == ','){
                        count++;
                        continue;
                    }
                    if(temp.charAt(i) == '}'){
                        map.put(count, temp.substring(index + 1, i));
                        index = i;
                        break;
                    }
                }
                
            }
            index++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int j=0; j<map.size(); j++){
            String[] arr = map.get(j).split(",");
            for(int i=0; i<arr.length; i++){
                int result = Integer.parseInt(arr[i]);
                if(!set.contains(result)){
                    set.add(result);
                    ans.add(result);
                }
            }
        }
        
        answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}