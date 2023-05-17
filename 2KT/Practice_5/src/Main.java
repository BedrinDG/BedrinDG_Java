import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int x = 4;
        while(x > 0){
            int i = scan.nextInt();
            list.add(i);
            x--;
        }
        System.out.println(summ(list));
    }
    public static int summ(ArrayList<Integer> list){
        int count = 0;
        for(int i:list){
            count += i*i;
        }
        return count;
    }

}