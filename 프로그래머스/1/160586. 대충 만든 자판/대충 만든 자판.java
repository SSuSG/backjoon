import java.util.*;
class Solution {
    static HashMap<Character,Integer> map;
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        map = new HashMap<>();
        
        for(int i = 0 ; i < keymap.length ; i++){
            char[] temp = keymap[i].toCharArray();
            
            for(int j = 0 ; j < temp.length ; j++){
                map.put(temp[j] ,  Math.min( map.getOrDefault(temp[j],j+1) , j+1 ) );
            }
        }
        
        for(int i = 0 ; i < targets.length ; i++){
            int sum = 0;
            boolean isSuccess = true;
            for(int j = 0 ; j < targets[i].length() ; j++){
                int temp = map.getOrDefault(targets[i].charAt(j) , 0);
                if(temp == 0)
                    isSuccess = false;
                sum += temp;
            }
            
            if(isSuccess)
                answer[i] = sum;
            else
                answer[i] = -1;
        }
        
        
        return answer;
    }
}