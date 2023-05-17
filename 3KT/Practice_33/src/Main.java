import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long numberOfSticks = scan.nextLong();
        long tanyaSticks = 0;
        while (numberOfSticks > 0) {
            if (numberOfSticks % 2 == 1) {
                numberOfSticks--;
                tanyaSticks++;
            } else {
                long x = numberOfSticks / 2;
                long y = numberOfSticks - 1;
                if (x > y) {
                    numberOfSticks /= 2;
                } else {
                    numberOfSticks--;
                }
            }
        }
        System.out.println(tanyaSticks);
    }
}