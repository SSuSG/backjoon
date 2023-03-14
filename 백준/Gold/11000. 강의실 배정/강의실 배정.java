import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static Lesson[] lessons;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		lessons = new Lesson[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			lessons[i] = new Lesson(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lessons);
		int result = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lessons[0].end);
		int idx = 1;

		while(idx < n) {
			
			int curEnd = pq.poll();
			
			if(curEnd > lessons[idx].start) {
				result++;
				pq.offer(curEnd);
			}
			pq.offer(lessons[idx].end);
			idx++;
		}
		
		System.out.println(result);
	}
	
	static class Lesson implements Comparable<Lesson>{
		int start;
		int end;
		public Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Lesson o) {
			if(this.start == o.start)
				return this.end-o.end;
			return this.start-o.start;
		}
	}
}