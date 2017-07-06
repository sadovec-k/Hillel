package Lesson12;

import java.util.regex.Pattern;

/**
 * Created by Kostya on 04.07.2017.
 */
public class Lesson12 {
    private String patternNumber = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patternEmailsToChange = "(?i)(?:(?:@mail\\.ru)(?:,|$))+$";
    private String patternEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";
    private String newValue = "@gmail.com";

    public Lesson12(){

    }

    public boolean numbers(String input) {
        return Pattern.matches(this.patternNumber, input);
    }
    public boolean emails(String input) {
        return Pattern.matches(this.patternEmails, input);
    }

    public String newEmails(String input) {

        return input.replaceAll(this.patternEmailsToChange,this.newValue);
    }

}
