import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static List<Point> pointList;						//입력받은 좌표들을 저장
	static List<Bonguri> bList = new ArrayList<>();		//봉우리를 저장하는 리스트
	static boolean[] isContained;						//봉우리가 다른 봉우리에 의해 포함되는지 확인
	static boolean[] isContain;							//봉우리가 다른 봉우리를 포함하는지 확인
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		pointList = new ArrayList<>();
		//입력받는 좌표를 저장해준다.
		int minX = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pointList.add(new Point(x,y));
			minX = Math.min(minX, x);
		}
		
		int targetIdx = 0;
		int minY = 0;
		for (int i = 0; i < n; i++) {
			Point cur = pointList.get(i);
			if(cur.x == minX && minY > cur.y) {
				minY = cur.y;
				targetIdx = i;
			}
		}
		
		for (int i = 0; i < targetIdx; i++) {
			pointList.add(pointList.get(i));
		}
		
		int i = 0;
		while(targetIdx > 0) {
			pointList.remove(i);
			targetIdx--;
		}
		
		//yZeroCnt는 입력받은 좌표들을 가지고 다각형을 그릴때 선분이  x축에 닿는경우의 수를 카운트 해준다.
		//yZeroCnt가 2가 되면 x축에 두번 닿았다는 뜻이고 이는 봉우리가 형성 되었음을 의미한다.
		int yZeroCnt = 0;
		//입력받은 x좌표를 임시저장하는 x1,x2변수
		int x1 = 0;
		int x2 = 0;

		while(i < n-1) {
			Point cur = pointList.get(i);
			Point next = pointList.get(i+1);
			//선분이 x축에 닿았을경우
			//특정 좌표의  y값이  0보다 작은데 다음좌표의 y값이 0보다 크거나 특정 좌표의  y값이  0보다 큰데 다음좌표의 y값이 0보다 작은 경우
			if( (cur.y < 0 && next.y > 0) || (cur.y > 0 && next.y < 0)) {
				yZeroCnt++;
				if(yZeroCnt == 1)
					x1 = cur.x;
				else if(yZeroCnt == 2)
					x2 = cur.x;
			}
			
			//선분이 x축에 두번 닿았을경우 봉우리가 형성
			if(yZeroCnt == 2) {
				//x1 > x2 일시 startX는 x2, endX는 x1
				if(x1 > x2)
					bList.add(new Bonguri(x2, x1));
				else
					bList.add(new Bonguri(x1, x2));
				//새로운 봉우리를 구하기 위해 값을 초기화 해준다.
				yZeroCnt = 0;
				x1 = 0;
				x2 = 0;
			}
			i++;
		}
		
		//봉우리가 다른 봉우리에 의해 포함되는지 확인하는 boolean배열
		isContained = new boolean[bList.size()];
		//봉우리가 다른 봉우리를 포함하는지 확인하는 boolean배열
		isContain = new boolean[bList.size()];
		
		//봉우리가 다른 봉우리에 의해 포함되는지 확인
		for (int k = 0; k < bList.size(); k++) {
			Bonguri b1 = bList.get(k);
			for (int j = 0; j < bList.size(); j++) {
				if(k == j ) continue;
				Bonguri b2 = bList.get(j);
				
				//b1 이 b2봉우리에 의해 포함이 되면
				if(b1.startX > b2.startX && b1.endX < b2.endX) {
					//b1이 어떤 봉우리에 의해 포함이 된다.
					isContained[k] = true;
					//b2는 어떤 봉우리를 포함한다.
					isContain[j] = true;
					
				}
			}
		}
		//다른 봉우리에 의해 포함되지 않는 봉우리의 개수
		int notContainedBonguriCnt = 0;
		//다른 봉우리를 포함하지 않는 봉우리 개수
		int notContainBonguriCnt = 0;
		for (int k = 0; k < bList.size(); k++) {
			//i번째 봉우리가 특정 봉우리에 의해 포함되었다면
			if(!isContained[k])
				notContainedBonguriCnt++;
			//i번째 봉우리가 다른 봉우리를 포함하지 않으면
			if(!isContain[k])
				notContainBonguriCnt++;
		}

		//다른 봉우리에 의해 포함되지 않는 봉우리의 개수 -> 전체 - 포함되는 봉우리 개수
		System.out.print(notContainedBonguriCnt + " ");
		//다른 봉우리를 포함하지 않는 봉우리 개수 -> 전체 - 무언가를 포함하는 봉우리 개수
		System.out.print(notContainBonguriCnt);
	}
	
	//봉우리의 시작 x 좌표와 끝 y좌표 
	static class Bonguri{
		int startX;
		int endX;

		public Bonguri(int startX, int endX) {
			this.startX = startX;
			this.endX = endX;
		}
	}
	
	//처음입력받는 좌표를 저장
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}