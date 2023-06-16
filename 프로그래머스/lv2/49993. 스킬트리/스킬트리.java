class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int size = skill.length();
        for(int i=0; i<skill_trees.length; i++){
            boolean ok = true;
            int index = 0;
            String temp = skill_trees[i];
            Loop1: for(int j=0; j<temp.length(); j++){
                char tp = temp.charAt(j);
                // 배우지 말아야할 스킬이 나오면 루프탈출
                for(int z = index + 1; z < size; z++){
                    if(skill.charAt(z) == tp){
                        ok = false;
                        break Loop1;
                    }
                }
                if(tp == skill.charAt(index)){
                    index++;
                }
                if(index == size){
                    break Loop1;
                }
            }
            if(ok){
                answer++;
            }
        }
        
        return answer;
    }
}