package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class programgers {
}

class Solution_lv2_1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i : scoville) {
            result.add(i);
        }

        while(result.peek() < K){
            if(result.size() < 2)
                return -1;
            int temp = result.poll() + result.poll()*2;
            result.add(temp);
            answer++;
        }

        return answer;
    }
}

class Solution_lv3_1 {
    static class disk{
        int start;
        int time;

        public disk(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int now =0;

        PriorityQueue<disk> q = new PriorityQueue(new Comparator<disk>() {
            @Override
            public int compare(disk j1, disk j2){
                return j1.start - j2.start;
            }
        });
        for (int i = 0; i < jobs.length; i++) {
            q.add(new disk(jobs[i][0] , jobs[i][1]));
        }

        PriorityQueue<disk> result = new PriorityQueue<>(new Comparator<disk>() {
            @Override
            public int compare(disk o1, disk o2) {
                return o1.time - o2.time;
            }
        });

        int count = 0;
        while(count < jobs.length){
            while(!q.isEmpty() && now>=q.peek().start){
                result.add(q.poll());
            }
            if(!result.isEmpty()){
                disk temp = result.poll();
                answer += temp.time + (now - temp.start);
                now += temp.time;
                count++;
            }else{
                now++;
            }

        }

        return answer/count;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6} , {30, 3}};
        int solution = solution(jobs);
        System.out.println("solution = " + solution);
    }
}

class Solution_lv3_2 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        PriorityQueue<Integer> pq_reverse = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (String operation : operations) {
            String[] temp = operation.split(" ");
            if(temp[0].equals("I")){
                int t = Integer.parseInt(temp[1]);
                pq.add(t);
                pq_reverse.add(t);
            }else if(temp[0].equals("D")){
                if(temp[1].equals("1")){ //최댓값 삭제
                    if(!pq_reverse.isEmpty()){
                        Integer tp1 = pq_reverse.poll();
                        pq.remove(tp1);
                    }

                }else if(temp[1].equals("-1")){ //최솟값 삭제
                    if(!pq.isEmpty()){
                        Integer tp2 = pq.poll();
                        pq_reverse.remove(tp2);
                    }
                }
            }
        }
        if(!pq.isEmpty())
            answer[1] = pq.poll();

        if(!pq_reverse.isEmpty())
            answer[0] = pq_reverse.poll();

        return answer;
    }

    public static void main(String[] args) {
        String[] st = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] solution = solution(st);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
