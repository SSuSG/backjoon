import java.util.*;
import java.io.*;
public class Main {
	static int n,l;
	static int[][] map;
	static boolean[] isVisit;		//경사로가 놓인지 확인
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        
        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        	
        for (int i = 0; i < n ; i++) {
        	//행 체크
			if(isMoveAble(i,true))
				result++;
			//열 체크
			if(isMoveAble(i,false))
				result++;
		}
        System.out.println(result);
        
	}
	
	static boolean isMoveAble(int orderIdx , boolean isRow) {
		isVisit = new boolean[n];
		if(isRow) {
			for (int x = 0; x < n-1; x++) {
				if(map[orderIdx][x] == map[orderIdx][x+1]) 
					continue;
				
				if(map[orderIdx][x]-map[orderIdx][x+1] == 1 ) {			//내려가는 경사로
					for (int i = x+1; i <=x+l ; i++) 
						if(i >= n || map[orderIdx][x] - map[orderIdx][i] != 1 || isVisit[i])
							return false;
						else
							isVisit[i] = true;
					
				}else if(map[orderIdx][x]-map[orderIdx][x+1] == -1){	//올라가는 경사로
					for (int i = x; i > x-l ; i--) 
						if(i < 0 || map[orderIdx][i] - map[orderIdx][x+1] != -1 || isVisit[i])
							return false;
						else
							isVisit[i] = true;
					
				}else {		//높이 차이가 2이상인 경우
					return false;
				}
			}
			
		}else {
			for (int y = 0; y < n-1; y++) {
				if(map[y][orderIdx] == map[y+1][orderIdx]) 
					continue;
				
				if(map[y][orderIdx]-map[y+1][orderIdx] == 1 ) {			//내려가는 경사로
					for (int i = y+1; i <=y+l ; i++) 
						if(i >= n || map[y][orderIdx] - map[i][orderIdx] != 1 || isVisit[i])
							return false;
						else
							isVisit[i] = true;
					
				}else if(map[y][orderIdx]-map[y+1][orderIdx] == -1){	//올라가는 경사로
					for (int i = y; i > y-l ; i--) 
						if(i < 0 || map[i][orderIdx] - map[y+1][orderIdx] != -1 || isVisit[i])
							return false;
						else
							isVisit[i] = true;
					
				}else {		//높이 차이가 2이상인 경우
					return false;
				}
			}
		}
		return true;
		
	}
}
