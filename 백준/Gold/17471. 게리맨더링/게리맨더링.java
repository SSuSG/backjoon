import java.util.*;
import java.io.*;
public class Main {
	static int n,min=Integer.MAX_VALUE;
	static boolean[] isVisit;
	static boolean[][] map;
	static int[] population,p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		population = new int[n+1];
		map = new boolean[n+1][n+1];
		isVisit = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int tempN = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tempN; j++) {
				int to = Integer.parseInt(st.nextToken());
				map[i][to] = true;
				map[to][i] = true;
			}
		}
		subs(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	static void subs(int cnt) {
		if(n+1 == cnt) {
			List<Integer> a = new ArrayList<Integer>();
			List<Integer> b = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				if(isVisit[i])
					a.add(i);
				else
					b.add(i);
			}
			
			if(a.size() == 0 || b.size() == 0)
				return;
			if(!isConnection(a) || !isConnection(b))
				return;
			int aSum = 0;
			for (int i : a) 
				aSum += population[i];
			int bSum = 0;
			for (int i : b) 
				bSum += population[i];
			min = Math.min(min, Math.abs(aSum-bSum));
			return;
		}
		
		isVisit[cnt] = true;
		subs(cnt+1);
		isVisit[cnt] = false;
		subs(cnt+1);
	}
	
	static boolean isConnection(List<Integer> l) {
		p = new int[n+1];
		make();
		for (int i = 0; i < l.size(); i++) {
			int a = l.get(i);
			for (int j = 0; j < l.size(); j++) {
				if(i==j) continue;
				int b= l.get(j);
				if(map[a][b])
					union(a,b);
			}
		}
		
		int lp = find(l.get(0));
		for (int i = 1; i < l.size(); i++) {
			if(lp != find(l.get(i)))
				return false;
		}
		return true;
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return;
		p[bRoot] = aRoot;
		return;
	}
	
	static int find(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}
}