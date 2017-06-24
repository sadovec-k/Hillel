import java.util.Scanner;
import java.util.regex.Pattern;

public class HW7 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new string");
        String inputString = in.nextLine();

        System.out.println(isGmail(inputString));
    }

    public static boolean isGmail(String inputString){
        return Pattern.matches("(?:[A-Za-z0-9\\.\\-\\_]+(?:@gmail\\.com)(?:\\,|$))+$", inputString);
    }
}
