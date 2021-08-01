package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int count = n;
        int temp=k;
        while(!queue.isEmpty()){
            if(temp != 1){
                queue.offer(queue.poll());
                temp--;
            }else{
                count--;
                if(count==0){
                    sb.append(queue.poll());
                }else{
                    sb.append(queue.poll()+", ");
                }
                temp=k;
            }
        }
        System.out.println("<"+sb+">");
    }
}
