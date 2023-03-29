import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;
        boolean[] isVisit = new boolean[people.length];
        Arrays.sort(people);
        while(left < right){
            if(people[left] + people[right] <= limit){
                isVisit[left] = true;
                isVisit[right] = true;
                answer++;
                left++;
                right--;
            }else{
                right--;
            }
        }
        for(int i = 0 ; i < people.length ; i++){
            if(!isVisit[i]) answer++;
        }
        
        return answer;
    }
}