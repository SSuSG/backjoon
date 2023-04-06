import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    static boolean[] isVisit;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        isVisit = new boolean[words.length];
        dfs(0,begin,words,target);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void dfs(int cnt , String cur , String[] words , String target){
        if(min < cnt) return;
        if(cur.equals(target)){
            min = Math.min(min,cnt);
            return;
        }
        //System.out.println(cur);
        
        for(int i = 0 ; i < words.length ; i++){
            if(isVisit[i]) continue;
            String word = words[i];
            int diffCnt = 0;
            for(int j = 0 ; j < word.length() ; j++){
                if(cur.charAt(j) != word.charAt(j)) diffCnt++;
            }
            if(diffCnt == 1){
                isVisit[i] = true;
                dfs(cnt+1,word,words,target);
                isVisit[i] = false;
            }
        }
        
    }
}