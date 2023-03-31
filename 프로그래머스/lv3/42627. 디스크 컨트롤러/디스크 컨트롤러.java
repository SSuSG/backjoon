import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0;
        int idx = 0;
        int now = 0;

        //하드디스크가 작업을 수행하고 있지 않을때는 요청이 들어온 순서대로
        //하드디스크가 작업을 수행하고 있을시에는 작업시간이 짧은거 먼저 수행한다.
        Arrays.sort(jobs , (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1,o2) -> o1[1]-o2[1] );
        
        
        while(cnt < jobs.length){
            //하나의 작업이 끝날때까지 요청이 들어온 작업을 pq에 넣어준다.
            while(idx < jobs.length && now >= jobs[idx][0] ){
                pq.add(jobs[idx]);
                idx++;
            }

            if(pq.isEmpty()){
                now = jobs[idx][0];
            }else{
                //작업 실행
                int[] work = pq.poll();
                now += work[1];
                answer += now-work[0];
                cnt++;    
            }
            

        }
        
        return answer / jobs.length;
    }
}