class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0;
        int end = p.length();
        
        for(int i = 0 ; i <= t.length()-p.length() ; i++){
            if( Long.parseLong(t.substring(start,end)) <= Long.parseLong(p) )
               answer++;
            start++;
            end++;
        }
        
        
        return answer;
    }
    

}