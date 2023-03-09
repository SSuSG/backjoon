import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static List<Var> l = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			l.add(new Var(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(l);
		
		for (Var v : l) {
			int size = pq.size();
			if(size < v.deadline) {
				pq.offer(v.cupNum);
			}else if(size == v.deadline){
				if(pq.peek() < v.cupNum) {
					pq.poll();
					pq.offer(v.cupNum);
				}
			}
		}
		long sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}
	
	static class Var implements Comparable<Var>{
		int deadline;
		int cupNum;
		public Var(int deadline, int cupNum) {
			this.deadline = deadline;
			this.cupNum = cupNum;
		}
		@Override
		public int compareTo(Var o) {
			if(this.deadline == o.deadline) {
				return o.cupNum - cupNum;
			}
			return deadline - o.deadline;
		}
	}
}