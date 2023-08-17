import java.util.*;

class Solution {
    
    static boolean[] isVisit;
    static int[] output;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        isVisit = new boolean[dungeons.length];
        output = new int[dungeons.length];
        func(0,k,dungeons);
        return max;
    }
    
    public void func(int cnt , int k , int[][] dungeons){
        if(cnt == dungeons.length ){
            int tempK = k;
            int sum = 0;
            
            for(int i = 0 ; i < dungeons.length ; i++){
                int idx = output[i];
                if(tempK < dungeons[idx][0]) continue;
                tempK -= dungeons[idx][1];
                sum++;
            }
            if(max < sum)
                max = sum;
            
            return;
        }
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(isVisit[i]) continue;
            
            isVisit[i] = true;
            output[cnt] = i;
            func(cnt+1,k,dungeons);
            isVisit[i] = false;
        }
    }
}