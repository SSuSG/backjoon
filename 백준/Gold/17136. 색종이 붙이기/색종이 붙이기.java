import java.util.*;
import java.io.*;
public class Main {
	static int[][] map = new int[10][10];
	static int min = Integer.MAX_VALUE;
	static int[] count = {0,5,5,5,5,5};
	static boolean[][] isVisit = new boolean[10][10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 10; i++) {
			st  =new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0,0,0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void solve(int x ,int y,int cnt) {
		if(x==10 && y==9) {
			//System.out.println(cnt);
			if(min > cnt)
				min = cnt;
			return;
		}
		
		if(x >= 10) {
			x = 0;
			y = y+1;
		}
		
		if(map[y][x] == 1 && !isVisit[y][x]) {
			//System.out.println(y + " " + x + " " + cnt);
			for (int k = 5; k >= 1; k--) {
				if(isAttach(x,y,k)) {
					attach(x,y,k);
					count[k]--;
					solve(x+1,y,cnt+1);
					dettach(x,y,k);
					count[k]++;
				}
			}
		}else {
			solve(x+1,y,cnt);
		}
	}
	
	static void attach(int x , int y , int size) {
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x + size; j++) {
				isVisit[i][j] = true;
			}
		}
	}
	
	static void dettach(int x , int y , int size) {
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x + size; j++) {
				isVisit[i][j] = false;
			}
		}
	}
	
	//색종이를 붙일수 있는지
	static boolean isAttach(int x , int y , int size) {
		if(count[size] <= 0)
			return false;
		
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x + size; j++) {
				if(i >= 10 | j >= 10)
					return false;
				if(map[i][j] != 1 || isVisit[i][j])
					return false;
			}
		}
		return true;
	}
	
}