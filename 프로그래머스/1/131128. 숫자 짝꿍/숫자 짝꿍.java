class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        char[] arrX = X.toCharArray();
        char[] arrY = Y.toCharArray();
        
        int checkX[] = new int[10];
        int checkY[] = new int[10];
        for(int i=0; i<arrX.length; i++){
            checkX[arrX[i]-'0']++;
        }
        for(int i=0; i<arrY.length; i++){
            checkY[arrY[i]-'0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=9; i>=0; i--){
            if(checkX[i] == 0 || checkY[i] == 0){
                continue;
            }
            int min = Math.min(checkX[i], checkY[i]);
            if(i == 0 && sb.length() == 0){
                min = 1;
            }

            for(int j=0; j<min; j++){
                sb.append(i);
            }
        }
        if(sb.toString().equals(""))
            return "-1";
        return sb.toString();
    }
}