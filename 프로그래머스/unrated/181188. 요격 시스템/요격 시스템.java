import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets , (o1,o2) -> ( o1[1] == o2[1] ) ? o1[0]-o2[0] : o1[1]-o2[1] );
        //도착이 빠른순으로 정렬
        int end = targets[0][1];
        answer++;
        for(int i = 1 ; i < targets.length ; i++){
            if(end <= targets[i][0]){
                answer++;
                end = targets[i][1];
            }
        }
        
        return answer;
    }
}