import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str_1 = scan.next();
        int str_idx1 = str_1.length()-1;
        String str_2 = scan.next();
        int str_idx2 = str_2.length()-1;
        int result = 0;
        while(str_idx2 != -1){
            if(str_2.charAt(str_idx2) == str_1.charAt(str_idx1)){
                result++;
            }
            str_idx1--;
            str_idx2--;
        }
        if(result == str_2.length()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}