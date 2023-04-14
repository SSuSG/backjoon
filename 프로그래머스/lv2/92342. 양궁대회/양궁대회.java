import java.util.*;
class Solution {
    static int[] output;
    static int[] answer;
    static int max = -1;
    public int[] solution(int n, int[] info) {
        output = new int[11];
        comb(0,n,info);
        if(max == -1) return new int[]{-1};
        return answer;
    }
    
    static void comb(int cnt, int n , int[] info){
        //n발을 쏜 후
        if(cnt == n){
            int lionSum = 0;
            int apSum = 0;
            
            //라이언,어피치의 점수 합 구하기
            for(int i = 0 ; i < 11 ; i++){
                if(info[i] > 0 && info[i] >= output[i]) 
                    apSum += 10-i;
                else if(output[i] > 0 && output[i] > info[i])
                    lionSum += 10-i;
            }
            int diff = lionSum - apSum;
            if(diff < 1) return;
            if(max < diff){
                max = diff;
                answer = output.clone();
                
            }else if(max == diff){
                for(int i = 10 ; i >= 0 ; i--){
                    if(answer[i] > 0 && output[i] == 0) break;
                    if(answer[i] == 0 && output[i] > 0){
                        answer = output.clone();
                        break;
                    }
                    if(answer[i] > 0 && output[i] > 0){
                        if(answer[i] >= output[i]) break;
                        else{
                            answer = output.clone();
                            break;
                        }
                    }
                }
                
            }
            
            return;
        }
        
        for(int i = 0 ; i <= 10 && output[i] <= info[i]; i++){
            output[i]++;
            comb(cnt+1,n,info);
            output[i]--;
        }
    }
}