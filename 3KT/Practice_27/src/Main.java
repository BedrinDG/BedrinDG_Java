import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Строка(На русском): ");
        String str = scan.nextLine();
        System.out.print("Число сдвига: ");
        int shiftNumber = scan.nextInt();
        System.out.print("Введите направление сдвига:\nright\nleft\n");
        String direction = scan.next();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if(symbol == ' '){
                result+=' ';
                continue;
            }
            if (direction.equals("right")) {
                symbol = (char) ((symbol-'а'+shiftNumber) % 32 + 'а');
            }
            else if (direction.equals("left")) {
                symbol = (char)((symbol-'а'-shiftNumber + 32) % 32 + 'а');
            }
            result += symbol;
        }
        System.out.println("Результат:\n" + result);
    }
}