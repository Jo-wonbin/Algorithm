import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        int supoza1 = 1;
        int supoza2 = 1;
        int supoza3 = 1;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == i%5 + 1){
                supoza1++;
            }
            if(answers[i] == supo2(i%8)){
                supoza2++;
            }
            if(answers[i] == supo3(i%10)){
                supoza3++;
            }
        }
        
        if(supoza1 > supoza2 && supoza1 > supoza3){
            list.add(1);
        }else if(supoza2 > supoza1 && supoza2 > supoza3){
            list.add(2);
        }else if(supoza3 > supoza2 && supoza3 > supoza1){
            list.add(3);
        }else if(supoza1 == supoza2 && supoza1 > supoza3){
            list.add(1);
            list.add(2);
        }else if(supoza1 == supoza3 && supoza1 > supoza2){
            list.add(1);
            list.add(3);
        }else if(supoza3 == supoza2 && supoza2 > supoza1){
            list.add(2);
            list.add(3);
        }else if(supoza1 == supoza2 && supoza2 == supoza3){
            list.add(1);
            list.add(2);
            list.add(3);
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    static int supo2(int index){
        if(index % 2 == 0){
            return 2;
        }else if(index == 1){
            return 1;
        }else if(index == 3){
            return 3;
        }else if(index == 5){
            return 4;
        }else if(index == 7){
            return 5;
        }
        return 0;
    }
    
    static int supo3(int index){
        if(index == 0 || index == 1){
            return 3;
        }else if(index == 2 || index == 3){
            return 1;
        }else if(index == 4 || index == 5){
            return 2;
        }else if(index == 6 || index == 7){
            return 4;
        }else if(index == 8 || index == 9){
            return 5;
        }
        return 0;
    }
}