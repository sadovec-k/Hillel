import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson8_1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new line");
        String inputString = in.nextLine();
        String rezaltString = "";

        String[] patternString = new String[11];

        patternString[0] = "^*+(\\d{2}:\\d{2}:\\d{2})";
        patternString[1] = "Activity: ";
        patternString[2] = "\\[Login Username:.+\\)\\]";
        patternString[3] = "\\[Data Object:[^\\]]+\\]";
        patternString[4] = "\\[Records:[^\\]]+\\]";
        patternString[5] = "\\[User Action:[^\\]]+\\]";
        patternString[6] = "\\[User Action Status:[^\\]]+\\]";
        patternString[7] = "\\[Labels:[^\\]]+\\]";
        patternString[8] = "\\[Service type:[^\\]]+\\]";
        patternString[9] = "\\[Mapping Ids:[^\\]]+\\]";
        patternString[10] = "\\[URI:[^\\]]+\\]";

        Pattern stringPattern = Pattern.compile(patternString[0]);
        Matcher rezalt = stringPattern.matcher(inputString);
        rezaltString = (rezalt.find()? inputString.substring(0, rezalt.end()): " ");

        for(int i = 1; i < patternString.length; i++){
            stringPattern = Pattern.compile(patternString[i]);
            rezalt = stringPattern.matcher(inputString);
            rezaltString = rezaltString + " " + (rezalt.find()? inputString.substring(rezalt.start(), rezalt.end()): "");
        }
        System.out.println(rezaltString);
    }
}
