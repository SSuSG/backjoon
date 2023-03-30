import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length ; i++)
            pq.add(scoville[i]);
        
        while(!pq.isEmpty()){
            int min = pq.poll();
            if(min >= K) break;
            if(pq.isEmpty()) return -1;
            int min2 = pq.poll();
            pq.add(min + min2*2);
            answer++;
        }
        
        return answer;
    }
}