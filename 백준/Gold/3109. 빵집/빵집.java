import java.util.*;
import java.io.*;
public class Main {
	static int r,c,cnt=0;
	static char[][] map;
	static boolean[][] isVisit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		isVisit = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < r; i++) {
			if(isSuccessMove(0,i))
				cnt++;

		}
		System.out.println(cnt);
	}
	
	static boolean isSuccessMove(int x,int y) {
		if(x == c-1) 
			return true;

		isVisit[y][x] = true;
		
		if(y-1 >= 0 && map[y-1][x+1] == '.' && !isVisit[y-1][x+1])
			if(isSuccessMove(x+1, y-1))
				return true;
		
		if(map[y][x+1] == '.' && !isVisit[y][x+1])
			if(isSuccessMove(x+1, y))
				return true;
		
		if(y+1 < r && map[y+1][x+1] == '.' && !isVisit[y+1][x+1])
			if(isSuccessMove(x+1, y+1))
				return true;
		
		return false;
	}
}