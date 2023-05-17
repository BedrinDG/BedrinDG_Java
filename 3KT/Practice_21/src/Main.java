import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.next().split("");
        String result = "";
        for(int i = 0; i < numbers.length; i++){
            int number = Integer.parseInt(numbers[i]);
            if(numbers[i].equals("1")||numbers[i].equals("2")||numbers[i].equals("3")) {
                result += number+6;
            }
            if(numbers[i].equals("4")||numbers[i].equals("5")||numbers[i].equals("6")||numbers[i].equals("0")){
                result += number;
            }
            if(numbers[i].equals("7")|| numbers[i].equals("8")|| numbers[i].equals("9")){
                result += number-6;
            }
        }
        System.out.println(result);
    }
}