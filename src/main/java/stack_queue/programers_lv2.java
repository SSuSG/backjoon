package stack_queue;

import java.util.*;

public class programers_lv2 {
}

class Solution_lv2_1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        Stack<Integer> result = new Stack<Integer>();

        for (int i = 0; i < progresses.length; i++) {
            int diff = 100 - progresses[i];
            if(diff%speeds[i] == 0){ //나누어 떨어지면
                days[i] = diff/speeds[i];
            }else{ //안나누어 떨어지면
                days[i] = diff/speeds[i]+1;
            }
        }
        for (int i = days.length-1; i >= 0 ; i--) {
            result.push(days[i]);
        }

        int i = 0 ;
        List<Integer> results = new ArrayList<>();

        while(!result.isEmpty()){
            int count = 0;
            int now  = result.pop();
            count++;

            while(!result.isEmpty()){
                if(now >= result.peek()){
                    result.pop();
                    count++;
                }else{
                    break;
                }
            }
           results.add(count);
        }
        int[] answer = new int[results.size()];
        for (int j = 0; j < results.size(); j++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}

class Solution_lv2_2 {
    static class file{
        int priority;
        int idx;


        public file(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int order = 1;
        LinkedList<file> files = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            files.add(new file(priorities[i] , i));
        }
        int[] result = new int[priorities.length];
        boolean flag = false;
        while(!files.isEmpty()){
            file temp = files.poll();

            for (int i = 0; i < files.size(); i++) {
                if(temp.priority < files.get(i).priority){
                    files.offer(temp);
                    flag = true;
                    break;
                }
                flag = false;
            }
            if(flag == false){
                result[temp.idx] = order;
                order++;
            }

        }
        answer = result[location];

        return answer;
    }
}

class Solution_lv2_3 {
    static class truck{
        int count;
        int weight;

        public truck(int count, int weight) {
            this.count = count;
            this.weight = weight;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        LinkedList<truck> bridge = new LinkedList<>();
        int can_num = 0;
        int weight_sum = 0;
        int i = 0;
        while(true){
            if(i == truck_weights.length && bridge.isEmpty())
                return answer-1;

            if(!bridge.isEmpty()){
                for (int j = 0; j < bridge.size(); j++) {
                    bridge.get(j).count++;
                }

                if(bridge.get(0).count == bridge_length){
                    can_num--;
                    weight_sum -= bridge.get(0).weight;
                    bridge.poll();
                }

            }

            if(i < truck_weights.length){
                if(can_num < bridge_length && weight_sum+truck_weights[i] <= weight){
                    bridge.offer(new truck(0,truck_weights[i]));
                    can_num++;
                    weight_sum += truck_weights[i];
                    i++;
                }
            }

            answer++;
        }
    }


    public static void main(String[] args) {
        int[] param = {10,10,10,10,10,10,10,10,10,10};
        int result = solution(100, 100, param);
        System.out.println("result = " + result);
    }
}

