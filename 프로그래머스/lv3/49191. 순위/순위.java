import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[] 강한사람수 = new int[n+1];
        int[] 약한사람수 = new int[n+1];
        boolean[] isVisit;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < results.length ; i++){
            int winner = results[i][0];
            int loser = results[i][1];
            list.get(winner).add(loser);
        }
        
        for(int i = 1 ; i <= n ; i++){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            isVisit = new boolean[n+1];
            
            while(!q.isEmpty()){
                int cur = q.poll();
                
                //cur에게 진 사람들
                for(int loser : list.get(cur)){
                    if(isVisit[loser]) continue;
                    isVisit[loser] = true;
                    강한사람수[loser]++;
                    약한사람수[i]++;
                    q.offer(loser);
                }
            }
        }
        
        //나보다 약한사람 + 강한사람수 == n-1 이라면 순위를 알수있다.
        for(int i = 1 ; i <= n ; i++)
            if(강한사람수[i] + 약한사람수[i] == n-1) answer++;
        
        return answer;
    }
}