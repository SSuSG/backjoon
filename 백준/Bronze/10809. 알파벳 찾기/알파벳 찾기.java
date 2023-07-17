import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		
		for(char i = 'a' ; i < 'z'+1 ; i++) {
			int temp = -1;
			for(int z = 0 ; z < s.length() ; z++) {
				if(i==s.charAt(z)) {
					temp = z;
					break;
				}
			}
			System.out.print(temp +" ");
		}
	}
}
