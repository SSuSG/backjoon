package kako;

import java.util.LinkedList;
import java.util.Queue;

public class solution2 {
    public static void main(String[] args) {

    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        forGoal(queue1,queue2);

        return answer;
    }

    public int forGoal(int[] queue1, int[] queue2){

        long sum1 =0;
        long sum2 =0;
        long goal = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        if( (sum1+sum2) %2 != 0){
            return -1;
        }
        goal = (sum1+sum2)/2;
        int k = 0;

        // 답을 만들수있는게 떨어져있으면 -1
        // 한 수가 goal보다 크면 -1
        return 5;
    }

}
