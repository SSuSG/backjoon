import java.io.*;
import java.time.Period;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] copyMap;
	static int min = Integer.MAX_VALUE;
	static int[] output;
	static ArrayList<CCTV> cctvList = new ArrayList<>();
	static int n,m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add( new CCTV(j,i,map[i][j]) );
				}
			}
		}
		output = new int[cctvList.size()];
		
		permutation(0);
		System.out.println(min);
	}
	
	//
	public static void permutation(int depth) {
		if(depth == cctvList.size()) {
			copyMap = new int[n][m];
			for (int i = 0; i < n; i++) 
				copyMap[i] = Arrays.copyOf(map[i], m);
			
			for (int i = 0; i < output.length; i++) 
				choiceDir(cctvList.get(i) , output[i]);
			
			//사각지대 사이즈 구함
			getResult();
			return;
		}
		
		//상 : 0 
		//하 : 1 
		//좌 : 2 
		//우 : 3
		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			permutation(depth+1);
		}
	}
	
	//cctv의 번호와 방향에 따라 cctv가 볼 방향 정하기
	public static void choiceDir(CCTV cctv , int dir) {
		for (int i = 0; i < output.length; i++) {
			if(cctv.num == 1) {
				if(dir == 0) {
					watch(cctv,0);
				}else if(dir == 1) {
					watch(cctv,1);
				}else if(dir == 2) {
					watch(cctv,2);
				}else if(dir == 3) {
					watch(cctv,3);
				}
				
			}else if(cctv.num == 2) {
				//상 하
				if(dir == 0 || dir == 1) {
					watch(cctv,0);
					watch(cctv,1);
				}
				
				//좌 우
				if(dir == 2 || dir == 3) {
					watch(cctv,2);
					watch(cctv,3);
					
				}
			}else if(cctv.num == 3) {
				//상 -> 상우
				if(dir == 0) {
					watch(cctv,0);
					watch(cctv,3);
				}
				
				//하 -> 하좌
				if(dir == 1) {
					watch(cctv,1);
					watch(cctv,2);
				}
				
				//좌 -> 좌상
				if(dir == 2) {
					watch(cctv,2);
					watch(cctv,0);
				}
				
				//우 -> 우하
				if(dir == 3) {
					watch(cctv,3);
					watch(cctv,1);
				}
				
			}else if(cctv.num == 4) {
				if(dir == 0) {
					watch(cctv,0);
					watch(cctv,1);
					watch(cctv,2);
				}else if(dir == 1) {
					watch(cctv,0);
					watch(cctv,1);
					watch(cctv,3);
				}else if(dir == 2) {
					watch(cctv,0);
					watch(cctv,2);
					watch(cctv,3);
				}else if(dir == 3) {
					watch(cctv,1);
					watch(cctv,2);
					watch(cctv,3);
				}
			}else if(cctv.num == 5) {
				watch(cctv,0);
				watch(cctv,1);
				watch(cctv,2);
				watch(cctv,3);
			}
		}
	}
	
	//cctv가 보는 방향 #으로 바꿈
	public static void watch(CCTV cctv , int d) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {cctv.y , cctv.x});
		
		while(!q.isEmpty()) {
			int[] curPoint = q.poll();
			
			int ny = curPoint[0] + dy[d];
			int nx = curPoint[1] + dx[d];
			
			if(ny < 0  || nx < 0 || ny >= n || nx >= m)
				break;
			
			if(copyMap[ny][nx] == 6)
				break;
			
			if(copyMap[ny][nx] >= 1 && copyMap[ny][nx] <= 5) {
				q.add(new int[] {ny,nx});
				continue;
			}
			q.add(new int[] {ny,nx});
			copyMap[ny][nx] = -1;
		}
	}
	
	public static void getResult() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(copyMap[i][j] == 0)
					result++;
			}
		}
		
		if(min > result)
			min = result;
	}
	
	//1번 한쪽방향
	//2번 양쪽방향
	//3번 직각방향
	//4번 세방향
	//5번 모든방향
	public static class CCTV {
		int x;
		int y;
		int num;
		
		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
