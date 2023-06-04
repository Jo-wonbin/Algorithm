import java.util.*;

class Solution {
    
    static char[] words  = {'A', 'E', 'I', 'O', 'U'};
    final int max = 5;
    
    public int solution(String word) {
        
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<5; i++){
            permutation(list, String.valueOf(words[i]));
        }
        
        for(int i=0; i<list.size(); i++){
            if(word.equals(list.get(i))){
                return i+1;
            }
        }
        
        return 0;
    }
    
    public void permutation(List<String> list, String word){
        if(word.length() > max){
            return;
        }
        
        if(!list.contains(word)){
            list.add(word);
        }
        
        for(int i=0; i<5; i++){
            permutation(list, word + words[i]);
        }
    }
}