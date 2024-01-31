class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int cardIndex1 = 0;
        int cardIndex2 = 0;
        int beforeCardIndex1 = 0;
        int beforeCardIndex2 = 0;
        int goalIndex = 0;
        boolean ok = true;
        
        while(goalIndex < goal.length){
            if(cardIndex1 < cards1.length){
                
                if(cards1[cardIndex1].equals(goal[goalIndex])){
                    goalIndex++;
                    cardIndex1++;
                }
            }
            if(goalIndex >= goal.length){
                break;
            }
            if(cardIndex2 < cards2.length){
                if(cards2[cardIndex2].equals(goal[goalIndex])){
                    goalIndex++;
                    cardIndex2++;
                }
            }
            if(cardIndex1 == beforeCardIndex1 && cardIndex2 == beforeCardIndex2){
                ok = false;
                break;
            }else{
                beforeCardIndex1 = cardIndex1;
                beforeCardIndex2 = cardIndex2;
            }
        }
        
        if(ok){
            return "Yes";
        }else{
            return "No";            
        }
    }
}