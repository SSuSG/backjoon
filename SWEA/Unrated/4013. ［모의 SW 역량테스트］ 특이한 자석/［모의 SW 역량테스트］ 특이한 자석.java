import java.util.*;
import java.io.*;
public class Solution {
	static int k;
	static int[][] rotation;
	static int[][] topni;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_톱니.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());
			topni = new int[5][8];
			rotation = new int[k][2];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					topni[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				rotation[i][0] = Integer.parseInt(st.nextToken());
				rotation[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int q = 0; q < k; q++) {
				isVisit = new boolean[5];
				rotate(rotation[q][0] , rotation[q][1]);
			}

			int sum = 0;
			// n -> 0 , s -> 1
			if(topni[1][0] == 1)
				sum += 1;
			if(topni[2][0] == 1)
				sum += 2;
			if(topni[3][0] == 1)
				sum += 4;
			if(topni[4][0] == 1)
				sum += 8;
			
			
			
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
	
	static void rotate(int topniNum , int rotateDir) {
		//시계방향 1 , 반시계방향 -1
		if(isVisit[topniNum]) return;
		isVisit[topniNum] = true;
		
		//돌릴지 말지는 톱니를 돌리기전을 바탕으로 결정
		int[] rotateBefore = Arrays.copyOf(topni[topniNum], 8);
		int[] rotateAfter = new int[8];

		//톱니 시계방향 회전
        if(rotateDir == 1) {
        	rotateAfter[0] = topni[topniNum][7];
            for (int i = 1; i < 8; i++) {
            	rotateAfter[i] = topni[topniNum][i-1];
            }
        }

        //톱니 반시계방향 회전
        if(rotateDir == -1) {
        	rotateAfter[7] = topni[topniNum][0];
            for (int i = 0;	 i < 7 ; i++) {
            	rotateAfter[i] = topni[topniNum][i+1];
            }
        }
        topni[topniNum] = rotateAfter;
		
			//1번 회전
		if(topniNum == 1) {
			if(rotateBefore[2] != topni[2][6]) 
				rotate(2,-rotateDir);	
		}else if(topniNum == 4) {
			//4번 회전
			if(rotateBefore[6] != topni[3][2]) 
				rotate(3,-rotateDir);
		}else if(topniNum == 2 || topniNum == 3){
			//2,3번 회전
			//오른쪽 비교
			if(rotateBefore[2] != topni[topniNum+1][6])
				rotate(topniNum+1,-rotateDir);
			//왼쪽 비교
			if(rotateBefore[6] != topni[topniNum-1][2])
				rotate(topniNum-1,-rotateDir);
		}
	}
}