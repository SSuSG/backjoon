import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int wanho1 = scores[0][0];
        int wanho2 = scores[0][1];
        //근무태도점수 내림차순 , 근무태도점수 같으면 동료평가점수 오름차순
        Arrays.sort(scores , (o1,o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        
        
        int prevScore = scores[0][1];
        
        for(int i = 1 ; i < scores.length ; i++){
            if(prevScore > scores[i][1]){
                if(scores[i][0] == wanho1 && scores[i][1] == wanho2 )
                    return -1;
                
                scores[i][0] = -1;
                scores[i][1] = -1;
                
            }else{
                prevScore = scores[i][1];
            }
        }
        
        Arrays.sort(scores , (o1,o2) -> {
            return (o2[0]+o2[1]) - (o1[0]+o1[1]);
        });
        
        for(int i = 0; i < scores.length ; i++) {
            if (scores[i][0] + scores[i][1] > wanho1 + wanho2) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer+1;
    }
}