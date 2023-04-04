import java.util.*;
import java.io.*;
public class Solution {
	static int n,m,result;
	static int[] taller;
	static int[] shorter;
	static boolean[] isVisit;
	static List<List<Integer>> list;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_톱니.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			taller = new int[n+1];
			shorter = new int[n+1];
			result = 0;
			list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				//b보다 작은 a
				list.get(b).add(a);
			}
			for (int i = 1; i <= n; i++) {
				isVisit = new boolean[n+1];
				bfs(i);
			}
			
			//나보다 작은놈 + 나보다 큰놈 == n-1이면 정답
			for (int i = 1; i <= n; i++) {
				if(shorter[i] + taller[i] == n-1)
					result++;
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (Integer i : list.get(start)) {
			q.offer(i);
			isVisit[i] = true;
			shorter[start]++;
			taller[i]++;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (Integer next : list.get(cur)) {
				if(isVisit[next]) continue;
				isVisit[next] = true;
				q.offer(next);
				shorter[start]++;
				taller[next]++;
			}
		}
	}
}