import java.io.*;
import java.util.*;
public class Main {
	static int nowCnt =0;
	static boolean isEnd = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) -'0';
			}
		}
		
		//가로 중복확인
		//세로 중복확인
		//위치한 3 x 3 칸의 중복확인
		solve(0,0,map);
	}
	
	static void solve(int x , int y , int[][] map) {
		if(isEnd) return;
		if(x == 9 && y == 8) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			isEnd = true;
			return;
		}
		
		if(x > 8) {
			x = 0;
			y = y+1;
		}
		
		if(map[y][x] == 0) {
			for (int i = 1; i <= 9; i++) {
				//가로 , 세로 , 사각형 중복에 걸리면
				if(isDupl(x,y,i,map))
					continue;
				
				map[y][x] = i;
				solve(x+1,y,map);
				map[y][x] = 0;
			}
		}else {
			
			solve(x+1,y,map);
		}
	}
	
	static boolean isDupl(int x, int y,int value , int[][] map) {
		//가로
		for (int i = 0; i < 9; i++) {
			if(map[y][i] == value)
				return true;
		}
		//세로
		for (int i = 0; i < 9; i++) {
			if(map[i][x] == value)
				return true;
		}
		
		//사각형
		for (int i = y/3*3; i < y/3*3+3; i++) {
			for (int j = x/3*3; j < x/3*3+3 ; j++) {
				if(map[i][j] == value)
					return true;
			}
		}
		return false;
	}
}