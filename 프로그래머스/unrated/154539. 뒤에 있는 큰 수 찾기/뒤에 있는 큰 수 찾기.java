import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> st = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for(int i = 0 ; i < numbers.length ; i++){
            if( st.isEmpty() || st.peek()[0] >= numbers[i])
                st.push(new int[]{numbers[i],i});
            else{               
                while( !st.isEmpty() && st.peek()[0] < numbers[i]){
                    int[] cur = st.pop();
                    answer[cur[1]] = numbers[i];    
                }
                st.push(new int[]{numbers[i],i});
            }
        }
        while(!st.isEmpty()){
            answer[st.pop()[1]] = -1;    
        }
        
        return answer;
    }
}