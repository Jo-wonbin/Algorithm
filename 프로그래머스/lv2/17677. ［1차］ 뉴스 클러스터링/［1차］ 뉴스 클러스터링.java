import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        
        for(int i=0; i < str1.length()-1; i++){
            char temp = str1.charAt(i);
            char temp1 = str1.charAt(i+1);
            if((temp >= 'A' && temp <= 'Z') && (temp1 >= 'A' && temp1 <= 'Z')){
                A.add(str1.substring(i, i+2));
            }
        }
        for(int i=0; i < str2.length()-1; i++){
            char temp = str2.charAt(i);
            char temp1 = str2.charAt(i+1);
            if((temp >= 'A' && temp <= 'Z') && (temp1 >= 'A' && temp1 <= 'Z')){
                B.add(str2.substring(i, i+2));
            }
        }
        
        List<String> gg = new ArrayList<>();
        List<String> hh = new ArrayList<>();
        
        Collections.sort(A);
        Collections.sort(B);
        
        for(String tpa : A){
            if(B.remove(tpa)){
                gg.add(tpa);
            }
            hh.add(tpa);
        }
        hh.addAll(B);
        if(hh.size() == 0 && gg.size() == 0){
            return 65536;
        }
        
        double aa = gg.size();
        double bb = hh.size();
        double ans = aa / bb;
        ans *= 65536;
        answer = (int)ans;
        
        
        return answer;
    }
}