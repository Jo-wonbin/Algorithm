class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = attacks[attacks.length-1][0];
        
        int successTime = 0;
        int nowHealth = health;
        int attackIndex = 0;
        for(int i=1; i<=lastAttackTime; i++){
            
            if(attacks[attackIndex][0] == i){
                nowHealth -= attacks[attackIndex][1];
                successTime = 0;
                attackIndex++;
                
                if(nowHealth <= 0){
                    return -1;
                }   
            }else{
                successTime++;
                if(successTime == bandage[0]){
                    nowHealth = nowHealth + bandage[2] <= health ? nowHealth + bandage[2] : health;
                    successTime = 0;
                }
                nowHealth = nowHealth + bandage[1] <= health ? nowHealth + bandage[1] : health;
            }
        }
        
        return nowHealth;
    }
}