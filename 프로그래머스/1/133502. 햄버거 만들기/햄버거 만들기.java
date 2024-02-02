import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        boolean flag = false;
        List<Integer> burger = new ArrayList<>();
        for(int i=0; i<ingredient.length; i++){
            burger.add(ingredient[i]);
        }
        int nowCnt = 0;
        
        for(int i=0; i<burger.size(); i++){
            if(burger.get(i) == 1){
                if(burger.size() - 1 >= i+3){
                    if(burger.get(i+1) == 2 && burger.get(i+2) == 3 && burger.get(i+3) == 1){
                        answer++;
                        for(int j=0; j<4; j++){
                            burger.remove(i);
                        }
                        i = i-3>=-1 ? i-3 : -1;
                    }
                }
            }
        }

        
        return answer;
    }
}