import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int dice[] = new int[7];
        int arr[] = {a, b, c, d};
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        int max = 0;
        int mIndex = 0;
        int nIndex = 0;
        for(int i=1; i<7; i++){
            if(max < dice[i]){
                max = dice[i];
                mIndex = i;
            }
            if(dice[i] == 1){
                nIndex = i;
            }
        }
        
        if(max == 4){
            answer = mIndex * 1111;
        }else if(max == 3){
            int tp = 10 * mIndex + nIndex;
            answer = tp*tp;
        }else if(max == 2){
            answer = 1;
            if(nIndex == 0){
                Arrays.sort(arr);
                answer = (arr[0] + arr[3]) * Math.abs(arr[0] - arr[3]); 
            }else{
                for(int i=1; i<7; i++){
                    if(dice[i] == 1){
                        answer *= i;
                    }
                }
            }
        }else{
            Arrays.sort(arr);
            answer = arr[0];
        }
        
        return answer;
    }
}