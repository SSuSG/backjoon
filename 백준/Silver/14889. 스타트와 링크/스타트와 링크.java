import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] isStartTeam;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		isStartTeam = new boolean[n+1];
		
		for (int i = 1; i <= n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		selectPeople(0,1);
		System.out.println(min);
	}
	
	static void selectPeople(int cnt , int idx) {
		if(cnt == n/2) {
			int startSum = 0;
			int linkSum = 0;
			
			for (int i = 1; i <= n; i++) {
				for (int j = i+1; j <= n; j++) {
					if(isStartTeam[i] && isStartTeam[j])
						startSum += (map[i][j] + map[j][i]);
					if(!isStartTeam[i] && !isStartTeam[j])
						linkSum += (map[i][j] + map[j][i]);
				}
			}
			if(min > Math.abs(startSum - linkSum))
				min = Math.abs(startSum - linkSum);
			
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			if(isStartTeam[i])
				continue;
			
			isStartTeam[i] = true;
			selectPeople(cnt+1 , i+1);
			isStartTeam[i] = false;
		}
	}
}