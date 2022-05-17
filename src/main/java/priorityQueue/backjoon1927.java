package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class backjoon1927 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int temp;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());

            if(temp == 0){
                Integer poll = pq.poll();
                if(poll == null){
                    System.out.println(0);
                }else{
                    System.out.println(poll);
                }
            }else{
                pq.add(temp);
            }
        }
    }
}
