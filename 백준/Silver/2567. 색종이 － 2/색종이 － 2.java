import java.util.*;
import java.io.*;
public class Main {
	static int n,result=0;
	static boolean[][] map = new boolean[101][101];			//검은색 스카프인 경우 true를 저장
	static boolean[][] isVisit = new boolean[101][101];		//검은색 스카프가 주변 둘레를 계산하였다면 true처리를 해준다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		//입력 받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//검은색 스카프부분을 방문처리 해주기
			for (int j = y ; j < y + 10 ; j++) {
				for (int k = x ; k < x + 10; k++) {
					map[j][k] = true;
				}
			}
		}
		
		//모든 맵을 돌아보면서
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				//검은색 스카프인 부분일시
				if(map[i][j]) {
					//아래칸을 둘레로 포함시키고 
					if(i+1 < 101 && !map[i+1][j] && !isVisit[i][j]) {
						result++;
					}
					//위쪽칸을 둘레로 포함시키고 
					if(i-1 >= 0 && !map[i-1][j] && !isVisit[i][j]) {
						result++;
					}
					//오른쪽칸을 둘레로 포함시키고 
					if(j+1 < 101 && !map[i][j+1] && !isVisit[i][j]) {
						result++;
					}
					//왼쪽칸을 둘레로 포함시키고 
					if(j-1 >= 0 && !map[i][j-1] && !isVisit[i][j]) {
						result++;
					}
					//방문처리를 하여 중복을 방지
					isVisit[i][j] = true;
				}
			}
		}
		
		
		System.out.println(result);
	}
}