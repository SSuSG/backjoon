import java.io.*;
import java.util.*;

public class Main {
	static int n,m,r;
	static int[][] map;
	static int[] rNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		rNum = new int[r];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			rNum[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < r; i++) {
			switch (rNum[i]) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		for (int j = 0; j < map.length; j++) {
			for (int j2 = 0; j2 < map[0].length; j2++) {
				System.out.print(map[j][j2] + " ");
			}
			System.out.println();
		}
		
	}
	//상하반전
	static void one() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[r-1-i][j] = map[i][j];
			}
		}
		
		map = temp;
	}
	//좌우반전
	static void two() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][c-1-j] = map[i][j];
			}
		}
		map = temp;
	}
	
	//오른쪽 90
	static void three() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[c][r];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[j][r-1-i] = map[i][j];
			}
		}
		
		map = temp;
	}
	
	//왼쪽 90
	static void four() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[c][r];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[c-1-j][i] = map[i][j];
			}
		}
		
		map = temp;
	}
	
	static void five() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[r][c];
		
		// 1 -> 2
		for (int i = 0; i < r/2; i++) {
			for (int j = 0; j < c/2; j++) {
				temp[i][j+c/2] = map[i][j];
			}
		}
		
		// 2 -> 3
		for (int i = 0; i < r/2; i++) {
			for (int j = c/2; j < c; j++) {
				temp[i+r/2][j] = map[i][j];
			}
		}
		// 3 -> 4
		for (int i = r/2; i < r; i++) {
			for (int j = c/2; j < c; j++) {
				temp[i][j-c/2] = map[i][j];
			}
		}
		// 4 -> 1
		for (int i = r/2; i < r; i++) {
			for (int j = 0; j < c/2; j++) {
				temp[i-r/2][j] = map[i][j];
			}
		}
		
		map = temp;
	}
	
	static void six() {
		int r = map.length;
		int c = map[0].length;
		
		int[][] temp = new int[r][c];
		
		//1 -> 4
		for (int i = 0; i < r/2; i++) {
			for (int j = 0; j < c/2; j++) {
				temp[i+r/2][j] = map[i][j];
			}
		}
		
		//4 -> 3
		for (int i = r/2; i < r; i++) {
			for (int j = 0; j < c/2; j++) {
				temp[i][j+c/2] = map[i][j];
			}
		}
		//3 -> 2
		for (int i = r/2; i < r; i++) {
			for (int j = c/2; j < c; j++) {
				temp[i-r/2][j] = map[i][j];
			}
		}
		
		//2 -> 1
		for (int i = 0; i < r/2; i++) {
			for (int j = c/2; j < c; j++) {
				temp[i][j-c/2] = map[i][j];
			}
		}
		
		map = temp;
	}
}