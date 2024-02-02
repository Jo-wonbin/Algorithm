class Solution {
    public int solution(int num) {
        int cnt = 0;
        long num1 = (long)num;
        while(true){
            if(cnt >= 500){
                return -1;
            }
            if(num1 == 1){
                return cnt;
            }
            
            if(num1 % 2L == 0){
                num1 /= 2L;
            }else{
                num1*=3L;
                num1+=1L;
            }
            cnt++;
        }
    }
}