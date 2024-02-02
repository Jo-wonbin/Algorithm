class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n%3==0){
                sb.append(0);
            }else{
                sb.append(n%3);
            }
            n/=3;
        }
        
        String reverse = sb.toString();
        int size = reverse.length();
        for(int i=0; i<size; i++){
            int value = reverse.charAt(i)-'0';
            answer += (value * (int)Math.pow(3, size - 1 - i));
        }
        
        return answer;
    }
}