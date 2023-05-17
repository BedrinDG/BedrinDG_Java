import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(func(scan.nextInt()));
    }
    public static int func(int number){
        int result = 0;
        if(number == 0){
            return 0;
        }
        if(number == 1){
            result++;
        }
        if(number % 2 == 0){
            while(number % 2 == 0){
                number /=2;
            }
            if(number % 3 > 0){
                result++;
                number -=2;
            }
        }
        if(number % 3 >= 0){
            while(number % 3 >= 0){
                result++;
                number -=2;
            }
        }
        return result;
    }
}