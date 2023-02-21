import java.io.*;
import java.util.*;

public class Main {
	static int max = 0,c=0;
	static int[] dice;
	static boolean isFirst;
	static Node start;
	static int[] horse;
	static Node[] horseNode;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		dice = new int[11];
		horse = new int[11];
		isVisit = new boolean[5];
		horseNode = new Node[5];
		
		for (int i = 1; i <= 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		

		
		//중복순열
		init();
		perm(1);
		System.out.println(max);
	}
	
	static void perm(int cnt) {
		if(cnt == 11) {
			for (int i = 1; i <= 4; i++) {
				horseNode[i] = start;
			}
			
			int sum = 0;
			//10개의 주사위
			for (int i = 1; i <= 10; i++) {
				int d = dice[i];
				Node temp = horseNode[horse[i]];
				temp.isEmpty = true;
				//System.out.println(horse[i] + "번말 현재칸 : " + temp.value + " " + d + "이동할것임");
				//도착칸에 있으면 움직이지 않는다.
				if(temp.isFinish)
					continue;
				
				isFirst = true;
				//주사위 수 만큼 말을 움직인다.
				while(d > 0) {
					if(temp.isFinish)
						break;
					
					if(isFirst && temp.shortCutNode != null) {
						temp = temp.shortCutNode;
					}else {
						temp = temp.nextNode;						
					}
					d--;
					isFirst = false;
				}
				horseNode[horse[i]] = temp;
				
				if(!temp.isEmpty && !temp.isFinish)
					break;
					
				temp.isEmpty = false;
				sum += temp.value;
			}
			//System.out.println();
			for (int i = 1; i <= 4; i++) {
				horseNode[i].isEmpty = true;
			}
			
			if(max < sum)
				max = sum;
			return;
		}
		
		for (int i = 1; i <= 4 ; i++) {
			horse[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static void init() {
		start = new Node(0);
		Node temp = start;
		for (int i = 2; i <= 40; i+=2) {
			temp = temp.addNext(new Node(i));
		}
		
		Node end = temp.addNext(new Node(0));
		end.isFinish = true;
		end.nextNode = end;
		
		Node centerNode = new Node(25);
		temp = centerNode.addNext(new Node(30));
		temp = temp.addNext(new Node(35));
		temp.nextNode = Node.findNode(start, 40);
		
		temp = Node.findNode(start, 10);
		temp = temp.shortCutNode = new Node(13);
		temp = temp.addNext(new Node(16));
		temp = temp.addNext(new Node(19));
		temp.nextNode = centerNode;
		
		temp = Node.findNode(start, 30);
		temp = temp.shortCutNode = new Node(28);
		temp = temp.addNext(new Node(27));
		temp = temp.addNext(new Node(26));
		temp.nextNode = centerNode;
		
		temp = Node.findNode(start, 20);
		temp = temp.shortCutNode = new Node(22);
		temp = temp.addNext(new Node(24));
		temp.nextNode = centerNode;
	}
	
	static class Node{
		int value;
		boolean isEmpty,isFinish;
		Node nextNode , shortCutNode;
		
		public Node(int value) {
			this.value = value;
			this.isEmpty = true;
		}
		
		public Node addNext(Node node) {
			this.nextNode = node;
			return this.nextNode;
		}
		
		static Node findNode(Node start,int target) {
			Node temp = start;
			while(true) {
				if(temp == null)
					return null;
				if(temp.value == target) {
					return temp;
				}
				temp = temp.nextNode;
			}
		}
	}
}