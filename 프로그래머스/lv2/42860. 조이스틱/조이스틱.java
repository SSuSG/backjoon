import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n-1;
        
        for(int i = 0 ; i < n ; i++){
            answer +=  Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int index = i + 1;
            //A의 마지막위치+1
            while(index < n && name.charAt(index) == 'A')
                index++;
            
            //그냥이동
            //오른쪽으로 갔다가 왼쪽으로 이동
            //왼쪽으로 갔다가 오른쪽으로 이동
            move = Math.min(move , Math.min(i * 2 + n - index , (n-index)*2 + i  ) );
            
        }
        
        return answer+move;
    }
}