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
		
		//만약 검은색 스카프가 흰색천의 변과 딱 붙어있을경우 그 둘레를 더해준다
		//왜냐면 위쪽에서는 검은색스카프가 흰색스카프변에 붙어있을시 둘레의 길이를 더해주지 않았다.
		//x가 0,100인곳에 검은색 스카프가 있는 경우 
		for (int y = 0; y < 101; y++) {
			if(map[y][0])
				result++;
			if(map[y][100])
				result++;
		}
		
		//y가 0,100인곳에 검은색 스카프가 있는 경우 
		for (int x = 0; x < 101; x++) {
			if(map[0][x])
				result++;
			if(map[100][x])
				result++;
		}
		
		System.out.println(result);
	}
}