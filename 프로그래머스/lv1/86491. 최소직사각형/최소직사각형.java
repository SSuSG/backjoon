import java.util.*;
class Solution {

    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        int maxCol = 0;
        int maxRow = 0;
        
        for(int i = 0 ; i < sizes.length ; i++){
            int max = 0;
            int min = 0;
            if(sizes[i][0] > sizes[i][1]){
                max = sizes[i][0];
                min = sizes[i][1];
            }else{
                max = sizes[i][1];
                min = sizes[i][0];
            }
            
            maxRow = Math.max(maxRow,max);
            maxCol = Math.max(maxCol,min);
        }
        answer = Math.min(answer,maxRow * maxCol);
       
        
        return answer;
    }
}