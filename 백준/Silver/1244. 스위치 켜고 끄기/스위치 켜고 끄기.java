import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] switchStatus;
	static Student[] students;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		switchStatus = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			switchStatus[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int studentNum = Integer.parseInt(st.nextToken());
		students = new Student[studentNum];
		
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < studentNum; i++) {
			Student student = students[i];
			//남학생
			if(student.s == 1) {
				for (int j = 1; j <= n; j++) {
					if(j%student.num == 0)
						switchStatus[j] = switchStatus[j] == 1 ? 0 : 1;
				}
				
			}else {
				switchStatus[student.num] = switchStatus[student.num] == 1 ? 0 : 1;
				for (int j = 1; j < switchStatus.length/2 ; j++) {
					if(student.num - j < 1 || student.num + j > n)
						break;
					
					if(!(switchStatus[student.num-j] == switchStatus[student.num+j])) 
						break;
					
					switchStatus[student.num-j] = switchStatus[student.num-j] == 1 ? 0 : 1;
					switchStatus[student.num+j] = switchStatus[student.num+j] == 1 ? 0 : 1;
				}
			}
				
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(switchStatus[i] + " ");
			if(i%20 == 0)
				System.out.println();
		}
	}
	static class Student{
		int s;		//성별
		int num;	//받은 자연수

		public Student(int s, int num) {
			this.s = s;
			this.num = num;
		}
	}
}