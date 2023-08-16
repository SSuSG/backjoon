import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        ArrayDeque<Integer> assistBelt = new ArrayDeque<>();
        int idx = 0;
        int currentBox = 1;
        
        while(idx < order.length) {
            
            if(currentBox < order[idx]){
                assistBelt.push(currentBox);
                currentBox++;
                
            }else if(currentBox == order[idx]){
                answer++;
                idx++;
                currentBox++;
                
            }else{
                
                while(!assistBelt.isEmpty() && order[idx] == assistBelt.peek()){
                    assistBelt.pop();
                    answer++;
                    idx++;
                }
                
                if(idx >= order.length || order[idx] < currentBox) break;
            }
            
        }
        
        
        return answer;
    }
}