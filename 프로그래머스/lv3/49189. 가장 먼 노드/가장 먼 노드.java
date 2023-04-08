import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        
        int distance[] = new int[n+1];
        boolean visit[] =  new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int[] e : edge){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        visit[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            
            for(Integer a : list.get(now)){
                if(!visit[a]){
                    distance[a] = distance[now]+1;
                    queue.add(a); 
                    visit[a] = true; 
                }
            }
        }
        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            if(max < distance[i])
                max = distance[i];
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(max == distance[i])
                answer++;
        }
        
        
        return answer;
    }
    
    
}