import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] ik = scan
                .nextLine()
                .split(" ");
        ArrayList<String> brackets = new ArrayList<>();
        for(String i:ik){
            brackets.add(i);
        }
        
//        for(int i = 0; i > brackets.toArray().length;){
//            for(int j = 0; j > brackets.toArray().length; j++){
//
//            }
//        }
    }
}