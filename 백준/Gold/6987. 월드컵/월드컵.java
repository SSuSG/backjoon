import java.util.*;
import java.io.*;
public class Main {
	static int[] win,draw,loss,team1,team2;
	static boolean isValid;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			win = new int[6];
			draw = new int[6];
			loss = new int[6];
			isValid = false;
			int w=0,d=0,l=0;
			
			//입력 값 
			for (int i = 0; i < 6; i++) {
				w += win[i] = Integer.parseInt(st.nextToken());
				d += draw[i] = Integer.parseInt(st.nextToken());
				l += loss[i] = Integer.parseInt(st.nextToken());
			}
			if(w+d+l != 30) {
				sb.append(0 + " ");
				continue;
			}
			
			//모든 경기 경우의 수 구하기
			team1 = new int[15];
			team2 = new int[15];
			int cnt = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = i+1; j < 6; j++) {
					team1[cnt] = i;
					team2[cnt++] = j;
				}
			}
			//경기 마다 승,무,패 정하기
			solve(0);
			if(isValid)
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}
		System.out.println(sb);
	}
	
	static void solve(int idx) {
		if(isValid)
			return;
		
		if(idx == 15) {
			isValid = true;
			return;
		}
		
		//team1이 이겼을때
		if(win[team1[idx]] > 0 && loss[team2[idx]] > 0) {
			win[team1[idx]]--;
			loss[team2[idx]]--;
			solve(idx+1);
			win[team1[idx]]++;
			loss[team2[idx]]++;
		}
			
		//team1 team2가 비겼을때
		if(draw[team1[idx]] > 0 && draw[team2[idx]] > 0) {
			draw[team1[idx]]--;
			draw[team2[idx]]--;
			solve(idx+1);
			draw[team1[idx]]++;
			draw[team2[idx]]++;
		}
		
		//team2가 이겼을때
		if(loss[team1[idx]] > 0 && win[team2[idx]] > 0) {
			loss[team1[idx]]--;
			win[team2[idx]]--;
			solve(idx+1);
			loss[team1[idx]]++;
			win[team2[idx]]++;
		}
	}
}