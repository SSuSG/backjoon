import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int len = prices.length;
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0 ; i < len ; i++){
            if(st.isEmpty()){
                st.push(new int[]{prices[i],len-1-i,i});
                continue;
            }
            
            while(!st.isEmpty() && st.peek()[0] > prices[i]){
                int[] cur = st.pop();
                answer[cur[2]] = cur[1] - (len-1-i);
            }
            st.push(new int[]{prices[i],len-1-i,i});
        }
        
        while(!st.isEmpty()){
            int[] cur = st.pop();
            answer[cur[2]] = cur[1];
        }
        
        return answer;
    }
}