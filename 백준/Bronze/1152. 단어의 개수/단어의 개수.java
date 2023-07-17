import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String next = sc.nextLine();
        String trim = next.trim();
        String[] split = trim.split(" ");

        if(trim.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(split.length);    
        }
        
    }
}