import java.util.*;
import java.io.*;
public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxPq = new PriorityQueue<>( (o1,o2) -> o2-o1);
		PriorityQueue<Integer> minPq = new PriorityQueue<>( (o1,o2) -> o1-o2);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(maxPq.size() == minPq.size()) {
				maxPq.add(num);
			}else {
				minPq.add(num);
			}
			
			if(!maxPq.isEmpty() && !minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
				int temp = minPq.poll();
				minPq.add(maxPq.poll());
				maxPq.add(temp);
			}
			
			sb.append(maxPq.peek()+"\n");
		}
		System.out.println(sb);
	}
}