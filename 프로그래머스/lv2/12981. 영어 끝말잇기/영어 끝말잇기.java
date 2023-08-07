import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int count = 0;
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        for(int i = 1 ; i < words.length ; i++){
            if(set.contains(words[i])){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            set.add(words[i]);
            
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            } 
        }
        return answer;
    }
}