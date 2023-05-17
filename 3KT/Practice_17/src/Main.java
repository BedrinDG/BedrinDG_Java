import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        while (str.contains("()")) {
            str = str.replaceAll("\\(\\)", "");
        }
        System.out.println(str.length()==0);
    }
}