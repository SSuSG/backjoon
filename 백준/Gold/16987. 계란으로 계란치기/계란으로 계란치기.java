import java.util.*;
import java.io.*;
public class Main {
	static int n,max=0;
	static Egg[] eggs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		eggs = new Egg[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
		}
		dfs(0);
		System.out.println(max);
		
	}
	
	static void dfs(int idx) {
		if(idx == n) {
			int sum =0;
			for (int i = 0; i < n; i++) {
				if(eggs[i].d <= 0)
					sum++;
			}
			max = Math.max(max, sum);
			return;
		}
		
		if(eggs[idx].d <= 0) {
			dfs(idx+1);
		}else {
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if(i == idx) continue;
				if(eggs[i].d <= 0) continue;
				flag= true;
				eggs[idx].d -= eggs[i].w;
				eggs[i].d -= eggs[idx].w;
				dfs(idx+1);
				eggs[idx].d += eggs[i].w;
				eggs[i].d += eggs[idx].w;
			}
			//현재계란인에서 모든 계란이 모두깨진경우 다음 dfs로 넘어가질 못함
			if(!flag) dfs(idx+1);
		}

	}
	
	static class Egg{
		int d;
		int w;
		public Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
}