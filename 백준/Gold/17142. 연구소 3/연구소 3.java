import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int emptySpace = 0;
	static int[][] map;
	static boolean[][] infectedMap;
	static List<Virus> virusList = new ArrayList<>();
	static List<Virus> activeVirus = new ArrayList<>();
	static int minTime = Integer.MAX_VALUE;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					emptySpace++;
				if(map[i][j] == 2)
					virusList.add(new Virus(j,i,0));
			}
		}
		selectVirus(0,0);
		if(emptySpace == 0)
			System.out.println(0);
		else
			System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
		
	}
	
	public static void selectVirus(int depth , int startIdx) {
		if(depth == m) {
			bfs();
			return;
		}
		
		for (int i = startIdx; i < virusList.size(); i++) {
			Virus virus = virusList.get(i);
			activeVirus.add(virus);
			selectVirus(depth+1 , i+1);
			activeVirus.remove(activeVirus.size()-1);
		}
	}
	
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		infectedMap = new boolean[n][n];
		int emptySpaceCopy = emptySpace;
		
		for (Virus virus : activeVirus) {
			q.add(virus);
			infectedMap[virus.y][virus.x] = true;
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for (int[] dir : dirs) {
				int ny = virus.y + dir[0];
				int nx = virus.x + dir[1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < n && !infectedMap[ny][nx] && map[ny][nx] != 1) {
					if(map[ny][nx] == 0)
						emptySpaceCopy--;
					
					if(emptySpaceCopy == 0) {
						minTime = Math.min(minTime, virus.age+1);
						return;
					}
					
					q.add(new Virus(nx , ny , virus.age + 1));
					infectedMap[ny][nx] = true;
				}
			}
		}

	}
	
	public static class Virus{
		int x;
		int y;
		int age;
		public Virus(int x, int y,int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
}
