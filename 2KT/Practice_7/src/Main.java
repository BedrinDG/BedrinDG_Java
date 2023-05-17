import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        if(Math.sqrt(value)%1==0){
            System.out.println(Math.sqrt(value));
        }
        else{
            int value_min = value;
            int value_max = value;
            while(true){
                value_max +=1;
                value_min -=1;
                if(Math.sqrt(value_max)%1==0){
                    System.out.println(Math.sqrt(value_max));
                    break;
                } else if (Math.sqrt(value_min)%1==0){
                    System.out.println(Math.sqrt(value_min));
                    break;
                }
            }
        }
    }
}