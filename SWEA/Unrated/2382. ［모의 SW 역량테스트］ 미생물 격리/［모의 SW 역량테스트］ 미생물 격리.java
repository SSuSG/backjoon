import java.util.*;
import java.io.*;	
public class Solution {
	static int n,m,k,virusSum;
	static List<Virus> virusList;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1},
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	virusSum = 0;
        	virusList = new ArrayList<>();
        	for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int sum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				virusList.add(new Virus(y*n + x, x, y, sum, dir));
        		
			}
        	
        	while(m-- > 0) {
        		move();
        		Collections.sort(virusList , (v1,v2) -> v1.place == v2.place ? v2.sum - v1.sum : v1.place - v2.place);
        		combine();
        	}
        	for (Virus virus : virusList) 
				virusSum += virus.sum;
			
        	sb.append("#" + tc + " " + virusSum + "\n");
		}
        System.out.println(sb);
	}
	
	static void move() {
		for (int i = 0; i < virusList.size(); i++) {
			Virus virus = virusList.get(i);
			virus.x += dirs[virus.dir][1];
			virus.y += dirs[virus.dir][0];
			virus.place = virus.y * n + virus.x;
			
			if(virus.y  == 0 || virus.y  == n-1 || virus.x == 0 || virus.x == n-1) {
				virus.sum = virus.sum/2;
				virus.changeDir();
			}
			if(virus.sum == 0) {
				virusList.remove(i);
				i--;
			}
		}
	}
	
	static void combine() {
		for (int i = 0; i < virusList.size()-1; i++) {
			Virus v1 = virusList.get(i);
			Virus v2 = virusList.get(i+1);
			
			if(v1.place == v2.place) {
				v1.sum += v2.sum;
				virusList.remove(i+1);
				i--;
			}
		}
	}
	
	static class Virus{
		int place;
		int x;
		int y;
		int sum;
		int dir;
		public Virus(int place, int x, int y, int sum, int dir) {
			this.place = place;
			this.x = x;
			this.y = y;
			this.sum = sum;
			this.dir = dir;
		}
		void changeDir() {
			if(dir == 0) dir = 1;
			else if(dir == 1) dir = 0;
			else if(dir == 2) dir = 3;
			else if(dir == 3) dir = 2;
		}
	}
}