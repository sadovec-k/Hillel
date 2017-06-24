import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW6 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
            System.out.println("Enter new string");
            String s = in.nextLine();
            String firstPart = "[A-Za-z0-9\\.\\-\\_]+";
            Pattern emailPattern = Pattern.compile(firstPart + "@" + firstPart);
            Matcher rezalt = emailPattern.matcher(s);
        System.out.println(rezalt.find()? s.substring(rezalt.start(), rezalt.end()): "empty");
    }
}
