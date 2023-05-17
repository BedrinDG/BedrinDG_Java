import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numberString = scan.next();
        int numberInt = Integer.parseInt(numberString);
        int startOfRow = scan.nextInt();
        int u = startOfRow;
        int summ = 0;
        String[] number = numberString.split("");
        for(int i = 0; i < numberString.length(); i++){
            summ +=Math.pow((Integer.parseInt(number[i])),u);
            u++;
        }
        if(numberInt*startOfRow==summ){
            System.out.println("Да");
        }
        else{
            System.out.println("Нет");
        }

    }
}