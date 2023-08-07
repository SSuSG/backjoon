import java.util.*;
class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> st = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            if(st.size() == 0 )
                st.push(s.charAt(i));
            else if(st.peek() == s.charAt(i))
                st.poll();
            else
                st.push(s.charAt(i));
        }
        if(st.size() == 0)
            return 1;
        return 0;
    }
}