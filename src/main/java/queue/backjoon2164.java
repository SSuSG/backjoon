package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        Queue<Integer> queue = new LinkedList<>();
        while(true){
            queue.offer(num);
            num++;
            if(num == n+1)
                break;
        }
        while(true){
            if(queue.size()==1){
                System.out.println(queue.poll());
                return;
            }
            queue.poll();
            queue.offer(queue.poll());
        }
    }
}
