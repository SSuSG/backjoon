class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char now = s.charAt(0);
        int firstCnt = 0;
        int diffCnt = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(firstCnt == diffCnt){
                answer++;
                now = s.charAt(i);
            }
                
            if(now == s.charAt(i))
                firstCnt++;
            else
                diffCnt++;
            
        }
        
        return answer;
    }
}