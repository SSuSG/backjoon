import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int low = 0;
        int high = distance;
        while(low < high){
            int mid = (low+high)/2;
            int removeRock = 0;
            int prev = 0;
            for(int i = 0 ; i < rocks.length ; i++){
                if(rocks[i] - prev < mid ) 
                    removeRock++;
                else
                    prev = rocks[i];
            }
            if(distance - rocks[rocks.length-1] < mid) removeRock++;
            
            if(n < removeRock){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        
        return low-1;
    }
}