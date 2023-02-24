import java.util.*;
import java.io.*;
public class Main {
	static int n,m,fuel;
	static int[][] map;
	static Taxi taxi;
	static Node customer = new Node(1,1,-1);
	static Customer[] customers;
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
		fuel = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		taxi = new Taxi(c, r, fuel, 0);
		customers = new Customer[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			customers[i] = new Customer(startY,startX,endY,endX);
			map[startY][startX] = 2;
		}

		
		//m명의 고객을 태운다.
		for (int i = 0; i < m; i++) {
			//택시가 태울 승객을 찾는다.
			getCustomer();
			//벽에 막힌경우
			if(customer.dis == -1) {
				System.out.println(-1);
				return;
			}
			if(map[customer.y][customer.x] == 0) continue;
			
			//연료사용
			if(taxi.totalFuel >= customer.dis ) {
				taxi.totalFuel -= customer.dis;
			}else {
				System.out.println(-1);
				return;
			}
			
			//택시가 승객 있는곳으로 이동
			taxi.x = customer.x;
			taxi.y = customer.y;
			map[customer.y][customer.x] = 0;
			
			for (int j = 0; j < m; j++) {
				if(customer.x == customers[j].x && customer.y == customers[j].y) {
					int d = getDistance(customers[j].destX, customers[j].destY);
					if(d == -1) {
						System.out.println(-1);
						return;
					}
					
					//연료사용
					if(taxi.totalFuel >= d) {
						taxi.totalFuel -= d;
						taxi.useFuel += d;
					}else {
						System.out.println(-1);
						return;
					}
					
					//택시가 승객 있는곳으로 이동
					taxi.y = customers[j].destY;
					taxi.x = customers[j].destX;
				}
			}
			
			//연료 충전
			taxi.totalFuel += (taxi.useFuel * 2);
			taxi.init();
		}
		System.out.println(taxi.totalFuel);
		
	}
	static void getCustomer() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n+1][n+1];
		pq.add(new Node(taxi.y,taxi.x,0));
		visited[taxi.y][taxi.x] = true;
		
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			//System.out.println(p.y + " " + p.x);
			
			if(map[p.y][p.x] == 2) {
				customer = new Node(p.y,p.x,p.dis);
				return;
			}
			
			for (int[] dir : dirs) {
				int ny = p.y + dir[0];
				int nx = p.x + dir[1];
				
				if(nx >= 1 && ny >= 1 && nx <= n && ny <= n && map[ny][nx] != 1 && !visited[ny][nx]) {
					pq.offer(new Node(ny,nx,p.dis+1));
					visited[ny][nx] = true;
				}
			}
		}
		customer.dis = -1;
	}
	
	static int getDistance(int cx , int cy) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n+1][n+1];
		q.offer(new Node(taxi.y,taxi.x,0));
		visited[taxi.y][taxi.x] = true;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			
			if(cy == p.y && cx == p.x) {
				return p.dis;
			}
			
			for (int[] dir : dirs) {
				int ny = p.y + dir[0];
				int nx = p.x + dir[1];
				
				if(nx >= 1 && ny >= 1 && nx <= n && ny <= n && map[ny][nx] != 1 && !visited[ny][nx]) {
					q.offer(new Node(ny,nx,p.dis+1));
					visited[ny][nx] = true;
				}
			}
		}
		return -1;
	}

	static class Taxi{
		int x;
		int y;
		int totalFuel;
		int useFuel;
		public Taxi(int x, int y, int totalFuel, int useFuel) {
			this.x = x;
			this.y = y;
			this.totalFuel = totalFuel;
			this.useFuel = useFuel;
		}
		
		void init() {
			useFuel = 0;
		}
	}
	static class Customer{
		int x;
		int y;
		int destX;
		int destY;
		boolean isVisit;
		
		public Customer(int y, int x, int destY, int destX) {
			this.x = x;
			this.y = y;
			this.destX = destX;
			this.destY = destY;
			this.isVisit = false;
		}
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dis;
		
		public Node(int y, int x, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dis == o.dis) {
				if(this.y == o.y) {
					return this.x - o.x;
				} 
				return this.y - o.y;
			}
			return this.dis - o.dis;
		}
	}
}