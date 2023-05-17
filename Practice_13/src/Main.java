import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startOfRow = scan.nextInt();
        int step = scan.nextInt();
        int numberOfSteps = scan.nextInt();
        System.out.println(startOfRow);
        for(int i = 1; i < numberOfSteps; i++){
            startOfRow += step;
            System.out.println(startOfRow);
        }
    }
}