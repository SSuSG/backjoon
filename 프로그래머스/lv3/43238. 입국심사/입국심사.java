import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);     
        long low = 0;
        long high = (long)times[times.length-1]*n;
        
        while(low < high){
            long mid = (low+high)/2;
            long cnt = solve(mid,times);
            
            //cnt 가 n보다 클시 
            if(cnt >= n){
                high = mid;  
            }else{
                low = mid+1;
            }
        }
        System.out.println(low);
        return low;
    }
    
    static long solve(long mid , int[] times){
        long sum = 0;
        for(int i = 0 ; i < times.length ; i++){
            sum += (mid/times[i]);
        }
        return sum;
    }
    
    
}