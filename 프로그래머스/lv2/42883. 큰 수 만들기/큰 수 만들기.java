import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int n = number.length();
        
        //끝에서 k자리 만큼 까지의 max수를 넣기
        int start = 0;
        while(answer.length() < n-k){
            char max = '0';
            for(int i = start ; i <= k+answer.length() ; i++){
                if(max < number.charAt(i)){
                    max = number.charAt(i);
                    start = i+1;
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}