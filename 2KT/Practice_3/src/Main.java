import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[3];
        int[] y = new int[3];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<=2; i++){
            System.out.print("x_"+(i+1)+"= ");
            x[i] = scan.nextInt();
            System.out.print("y_"+(i+1)+"= ");
            y[i] = scan.nextInt();
        }
        float mY = (y[0] + y[1] + y[2]) /3F;
        float mX = (x[0]+x[1]+x[2])/3F;
        System.out.println(mX+" "+mY);
    }
}