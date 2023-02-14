import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final String[] sentences = {
			"\"재귀함수가 뭔가요?\"",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"",
			"라고 답변하였지.",
			"어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		System.out.println(sentences[6]);
		chatbot(0);
	}
	
	
	static void chatbot(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4*depth; i++) {
			sb.append("_");
		}
		
		if(depth == n) {
			System.out.println(sb + sentences[0]);
			System.out.println(sb + sentences[4]);
			System.out.println(sb + sentences[5]);
			return;
		}
		
		print(depth);
		chatbot(depth + 1);
		System.out.println(sb + sentences[5]);
		
	}
	
	static void print(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4*depth; i++) {
			sb.append("_");
		}
		
		System.out.println(sb + sentences[0]);
		System.out.println(sb + sentences[1]);
		System.out.println(sb + sentences[2]);
		System.out.println(sb + sentences[3]);
	}
}