package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class programers {
}

class Solutionlv3_1 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        int count[] = new int[n+1];
        boolean visit[] =  new boolean[n+1];

        for (int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>());
        }

        int a,b;
        for (int[] ints : edge) {
            a = ints[0];
            b = ints[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visit[0] = visit[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            for (Integer integer : list.get(now)) {
                if(!visit[integer]){ //만약 방문을 한적이없다면
                    count[integer] = count[now]+1;
                    visit[integer] = true;
                    queue.add(integer);
                }
            }
        }
        int max =0 ;
        for (int i = 1; i <= n; i++) {
            if(max < count[i])
                max = count[i];
        }
        for (int i = 1; i <= n ; i++) {
            if(max == count[i])
                answer++;
        }

        return answer;
    }
}

class Solutionlv3_2 {
    public static class node{
        int win;
        int defeat;
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        int count[] = new int[n+1];
        node[] nodes = new node[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
            nodes[i] = new node();
        }

        int win,lose;
        for (int[] result : results) {
            win = result[0];
            lose = result[1];

            list.get(win).add(lose);
        }

        for (int i = 1; i <= n ; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean visit[] = new boolean[n+1];
            queue.add(i);
            visit[i] =true;
            while(!queue.isEmpty()){
                int poll = queue.poll();

                for (int loser : list.get(poll)) {
                    if(!visit[loser]){
                        visit[loser] = true;
                        queue.add(loser);
                        nodes[i].win++;
                        nodes[loser].defeat++;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(nodes[i].win + nodes[i].defeat == n-1)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int solution = solution(5, results);
        System.out.println("solution = " + solution);
    }
}
