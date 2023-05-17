import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = scan.nextInt();
        int firstPlayer = scan.nextInt();
        ArrayList<Integer> player = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            player.add(i);
        }
        ArrayList<Integer> droppedOutPlayers = new ArrayList<>();
        int index = firstPlayer - 1;
        while (player.size() > 1){
            index = (index+2) % player.size();
            int f = player.remove(index);
            droppedOutPlayers.add(f);
            System.out.println("["+toString(player)+"] => "+f+" is counted out and goes into the result ["+toString(droppedOutPlayers)+"]");
        }
    }
    public static String toString(ArrayList<Integer> i){
        StringBuilder sb = new StringBuilder();
        for (Object o : i)
            sb.append(o+", ");
        String res = sb.toString().substring(0 ,sb.length()-2);
        return res;
    }
}