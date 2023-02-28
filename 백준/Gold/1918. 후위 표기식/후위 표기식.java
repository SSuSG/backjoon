import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Character> st = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			switch (cur) {
			case '*':
			case '/':
			case '+':
			case '-':
				while(!st.isEmpty() && getPriority(st.peek()) >= getPriority(cur)) {
					sb.append(st.pop());
				}
				st.push(cur);
				break;
			case '(':
				st.push(cur);
				break;
			case ')':
				while(!st.isEmpty()) {
					if(st.peek() == '(') {
						st.pop();
						break;
					}
					sb.append(st.pop());
				}
				break;
			default:
				sb.append(cur);
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
	}
	
	static int getPriority(char c) {
		if(c == '(' || c == ')')
			return 0;
		if(c == '+' || c == '-')
			return 1;
		if(c == '*' || c =='/')
			return 2;
		return -1;
	}
}