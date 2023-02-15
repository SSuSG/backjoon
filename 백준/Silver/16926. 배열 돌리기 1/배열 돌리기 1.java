import java.io.*;
import java.util.*;
public class Main {
	static int n,m,r;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(r >= 1) {
			rotate(0,n-1,0,m-1);
			r--;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void rotate(int startY , int endY , int startX , int endX) {
		if(startY >= endY || startX >= endX)
			return;
		
		int temp = map[startY][startX];
		for (int j = startX+1; j <= endX; j++) {
			map[startY][j-1] = map[startY][j];
		}
		
		for (int i = startY+1; i <= endY ; i++) {
			map[i-1][endX] = map[i][endX];
		}
		
		for (int j = endX-1; j >= startX; j--) {
			map[endY][j+1] = map[endY][j];
		}
		
		for (int i = endY-1; i >= startY+1 ; i--) {
			map[i+1][startX] = map[i][startX];
		}
		map[startY+1][startX] = temp;
		
		rotate(startY+1,endY-1,startX+1,endX-1);
	}
}