import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = -Long.MAX_VALUE;
        int n = sequence.length;
        long[] sum = new long[n+1];
        long max = -100001;
        long min = 100001;        

        for(int i = 1 ; i <= n ; i++){
            if(i%2 == 0){
                sum[i] = sum[i-1] + (long)(sequence[i-1] * -1);
            }else{
                sum[i] = sum[i-1] + (long)(sequence[i-1] * 1);
            }
            /*
            max = Math.max(max,sum[i]);
            min = Math.min(min,sum[i]);
            */
        }
        
        for(int i = 0; i < sum.length; i++) {
            max = Math.max(max,sum[i]);
            min = Math.min(min,sum[i]);
        }
        
        
        answer = Math.max(answer , Math.abs(max-min));
        return answer;
    }
}