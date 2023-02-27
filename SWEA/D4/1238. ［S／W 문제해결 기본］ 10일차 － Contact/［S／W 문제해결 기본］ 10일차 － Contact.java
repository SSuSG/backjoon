import java.util.*;
import java.io.*;
public class Solution {
	static int n,start,max;
	static boolean[][] map;
	static boolean[] isVisit;
	static List<Integer>[] l;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_contact.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;	
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());	
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			map = new boolean[101][101];
			isVisit=  new boolean[101];
			l = new List[100];
			for (int i = 0; i < 100; i++) {
				l[i] = new ArrayList<Integer>();
			}
			max = 0;
			
			st = new StringTokenizer(br.readLine());	
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = true;
			}
			ArrayDeque<int[]> q  = new ArrayDeque<>();
			q.offer(new int[] {start,0});
			isVisit[start] = true;
			l[0].add(start);
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				for (int i = 1; i < 101; i++) {
					if(map[now[0]][i] && !isVisit[i]) {
						isVisit[i] = true;
						q.offer(new int[] {i,now[1]+1});
						l[now[1]+1].add(i);
						cnt = now[1]+1;
					}
				}
			}
			Collections.sort(l[cnt]);

			sb.append("#" + tc + " " + l[cnt].get(l[cnt].size()-1) + "\n");
		}
		System.out.println(sb);
	}
}