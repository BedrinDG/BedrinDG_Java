import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = scan.nextInt();
        int secondNumber = scan.nextInt();
        int numberOfDivisors = scan.nextInt();
        int summ = 0;
        int[] divisors = new int[numberOfDivisors];
        for (int i = 0; i < numberOfDivisors; i++) {
            divisors[i] = scan.nextInt();
        }
        for (int i = firstNumber; i <= secondNumber; i++) {
            int a = numberOfDivisors;
            for (int j = 0; j < numberOfDivisors; j++) {
                if (i % divisors[j] != 0) {
                    a = 0;
                    break;
                }
            }
            if (a != 0) {summ += i;}
        }
        System.out.println(summ);
    }
}