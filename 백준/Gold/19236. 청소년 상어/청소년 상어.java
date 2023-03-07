import java.util.*;
import java.io.*;
public class Main {
	static int max = 0;
	static int[][] dirs = {
			{-1,0},
			{-1,-1},
			{0,-1},
			{1,-1},
			{1,0},
			{1,1},
			{0,1},
			{-1,1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[4][4];
		List<Fish> fishList = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int no = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				fishList.add(new Fish(j,i,dir-1,no,true));
				map[i][j] = no;
			}
		}
		Collections.sort(fishList , (o1,o2) -> Integer.compare(o1.no, o2.no));
		
		Fish temp = fishList.get(map[0][0]-1);
		Shark shark = new Shark(0,0,temp.d,temp.no);
		temp.isAlive = false;
		map[shark.y][shark.x] = -1; 
		
		solve(shark,map,fishList);
		System.out.println(max);
	}
	
	static void solve(Shark s , int[][] tmap , List<Fish> tlist) {
		if(max < s.eatSum)
			max = s.eatSum;
		
		//물고기 이동
		for (int i = 0; i <= 15; i++) {
			if(!tlist.get(i).isAlive) continue;
			Fish cur = tlist.get(i);
			
			
			for (int j = 0; j < 8; j++) {
				int nextD = (cur.d + j)%8; 
				int ny = cur.y + dirs[nextD][0];
				int nx = cur.x + dirs[nextD][1];

				if(isArea(nx,ny) && tmap[ny][nx] > -1) {
					if(tmap[ny][nx] > 0) {
						Fish temp = tlist.get(tmap[ny][nx]-1);
						tmap[ny][nx] = cur.no;
						tmap[cur.y][cur.x] = temp.no;
						
						temp.x = cur.x;
						temp.y = cur.y;
					}else {
						tmap[ny][nx] = cur.no;
						tmap[cur.y][cur.x] = 0;
					}
					cur.x = nx;
					cur.y = ny;
					cur.d = nextD;
					break;
				}
			}
			
		}
		
		//상어 이동
		for (int k = 1; k < 4; k++) {
			int ny = s.y + dirs[s.d][0]*k;
			int nx = s.x + dirs[s.d][1]*k;
			
			if(isArea(nx,ny) && tmap[ny][nx] > 0) {
				int[][] ttmap = new int[4][4];
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						ttmap[i][j] = tmap[i][j];
					}
				}
				
				List<Fish> ttlist = new ArrayList<>();
		        tlist.forEach(e -> ttlist.add(new Fish(e.x, e.y, e.d, e.no, e.isAlive)));
				
		        ttmap[s.y][s.x]= 0; 
		        Fish f = ttlist.get(tmap[ny][nx]-1);
				Shark shark = new Shark(f.x,f.y, f.d, s.eatSum + f.no);
				f.isAlive = false;
				ttmap[shark.y][shark.x] = -1; 
				
				solve(shark,ttmap,ttlist);
			}
		}
	}
	
	static boolean isArea(int nx , int ny) {
		if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 )
			return true;
		return false;
	}
	
	static class Shark{
		int x;
		int y;
		int d;
		int eatSum;
		
		public Shark(int x, int y, int d, int eatSum) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.eatSum = eatSum;
		}
	}
	
	static class Fish{
		int x;
		int y;
		int d;
		int no;
		boolean isAlive;

		
		public Fish(int x, int y, int d, int no , boolean isAlive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.no = no;
			this.isAlive = isAlive;
		}
	}
}