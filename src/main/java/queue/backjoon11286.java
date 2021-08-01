package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if(abs1==abs2) {
                    return o1-o2;
                }else {
                    return abs1-abs2;
                }

            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0 ){
                if(queue.size()==0){
                    sb.append(0+"\n");
                }else{
                    sb.append(queue.poll()+"\n");
                }
            }else{
                queue.add(temp);
            }
        }
        System.out.println(sb);

    }
}
