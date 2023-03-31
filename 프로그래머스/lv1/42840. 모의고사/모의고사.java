import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        for(int i = 0 ; i < answers.length ; i++){
            //1번 채점
            if(answers[i] == pattern1[i%5]) score[0]++;
            
            //2번 채점
            if(answers[i] == pattern2[i%8]) score[1]++;
            
            //3번 채점
            if(answers[i] == pattern3[i%10]) score[2]++;
        }
        
        int max = 0;
        max = Math.max(score[0],Math.max(score[1],score[2]));
        for(int i = 0 ; i < 3 ; i++){
            if(max <= score[i]) answer.add(i+1);
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}