import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] vowels = {"а", "ё", "у", "е", "э", "о", "ы", "я", "и","ю"};
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine()
                .toLowerCase();
        for(String i:vowels){
            str = str.replace(i,"");
        }
        System.out.println(str);
    }
}