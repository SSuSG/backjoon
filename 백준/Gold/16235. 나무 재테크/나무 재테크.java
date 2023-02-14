import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k;
	static Ground[][] map;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1},
			{-1,-1},
			{-1,1},
			{1,-1},
			{1,1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new Ground[n+1][n+1]; 
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = new Ground(j,i,Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			map[y][x].addTree(new Tree(age));
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Collections.sort(map[i][j].treeList);
			}
		}
		
		while(k-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int liveTreeNum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				liveTreeNum += map[i][j].treeList.size();
			}
		}
		
		System.out.println(liveTreeNum);
		
	}
	
	public static void spring() {
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				map[i][j].spring();
			}
		}
	}
	
	public static void summer() {
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				map[i][j].summer();
			}
		}
	}
	
	public static void fall() {
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				map[i][j].fall();
			}
		}
	}
	
	public static void winter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j].addFood();
			}
		}
	}
	
	public static class Ground{
		LinkedList<Tree> treeList;
		int food;
		int beAddedFood;
		int deadTreeAgeSum;
		int x;
		int y;
		
		public Ground(int x , int y , int beAddedFood) {
			this.treeList = new LinkedList<>();
			this.food = 5;
			this.x = x;
			this.y = y;
			this.deadTreeAgeSum = 0;
			this.beAddedFood = beAddedFood;
		}
		
		public void addTree(Tree tree) {
			this.treeList.addFirst(tree);
		}
	
		
		public void addFood() {
			this.food += beAddedFood;
		}
		
		public void spring() {
			Iterator<Tree> it = treeList.iterator();
			while(it.hasNext()) {
				Tree tree = it.next();
				
				if(this.food < tree.age) {
					deadTreeAgeSum += (int) tree.age/2;
					it.remove();
				}else {
					this.food -= tree.age;
					tree.addAge();
				}
			}
			
			
		}
		
		public void summer() {
			//죽은 나무들 양분화
			this.food += deadTreeAgeSum;
			deadTreeAgeSum = 0;
		}
		
		public void fall() {
			for (Tree tree : treeList) {
				if(tree.age%5 == 0) {
					for (int[] dir : dirs) {
						int ny = this.y + dir[0];
						int nx = this.x + dir[1];
						
						if(ny >= 1 && nx >= 1 && ny <= n && nx <= n) {
							map[ny][nx].addTree(new Tree(1));
						}
					}
				}
			}
		}
	}
	
	public static class Tree implements Comparable<Tree>{
		int age;
		
		public Tree(int age) {
			this.age = age;
		}
		
		public void addAge() {
			this.age += 1;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
}
