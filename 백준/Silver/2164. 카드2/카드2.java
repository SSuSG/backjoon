import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int n = Integer.parseInt(st.nextToken());
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