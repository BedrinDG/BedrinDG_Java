import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] ik = scan
                .nextLine()
                .split(" ");
        ArrayList<String> words = new ArrayList<>();
        for(String i:ik){
            words.add(i);
        }
        ArrayList<String> list = new ArrayList<>();
        while(words.isEmpty()==false){
            String word = words.get(0);
            list.add(word);
            while(words.indexOf(word) != -1){
                words.remove(word);
            }
        }
        System.out.println(String.join(" ", list));
    }
}