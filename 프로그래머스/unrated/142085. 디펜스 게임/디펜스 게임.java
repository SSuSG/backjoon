import java.util.*;
class Solution {
    static int maxRound = 0;
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        //pq에 남아있는 round는 무적권을 사용해서 막은 라운드
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < enemy.length ; i++){
            pq.add(enemy[i]);
            //막아야할 라운드가 무적권의 개수보다 많을시 가장적은 적을 가진 라운드를 빼준다.
            if(pq.size() > k) 
                n -= pq.poll();
   
            if( n < 0) return i;
        } 
        return enemy.length;
    }

}