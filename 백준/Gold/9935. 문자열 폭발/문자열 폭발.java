import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++ ) {
        	st.push(s.charAt(i));
        	
			if(s.charAt(i) == bomb.charAt(bomb.length()-1)) {
				boolean isValid = false;
				for (int j = st.size()-1 ,k = 1; j > st.size()-1-bomb.length(); j-- , k++) {
					if(j < 0 ) {
						isValid = false;
						break;
					}
					
					if(st.get(j) != bomb.charAt(bomb.length()-k)) {
						isValid = false;
						break;
					}
					isValid = true;
				}
				
				if(isValid) {
					for (int j = 0; j < bomb.length(); j++) {
						st.pop();
					}
				}
			}
		}
        StringBuilder sb = new StringBuilder();
        for (Character c : st) {
			sb.append(c);
		}
        System.out.println(sb.toString().length() == 0 ? "FRULA" : sb.toString());
	}
}