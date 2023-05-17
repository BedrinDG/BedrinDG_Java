import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int firstDivider = scan.nextInt();
        int secondDivider = scan.nextInt();
        int summ = 0;
        for (int i = 1; i <= n; i++) {
            if (i % firstDivider == 0 || i % secondDivider == 0) {
                summ += i;
            }
        }
        System.out.println(summ);
    }
}