import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "Example input string with various patterns to match.";

        System.out.println(input.matches("[a-zA-Z0-9]+"));

        System.out.println(input.matches("a*b.*"));

        System.out.println(input.matches("a+b.*"));

        System.out.println(input.matches("ab{3}.*"));

        System.out.println(input.matches("ab{2,3}.*"));

        Pattern p6 = Pattern.compile("[a-z]+_[a-z]+");
        Matcher m6 = p6.matcher(input);
        while (m6.find()) {
            System.out.println(m6.group());
        }

        Pattern p7 = Pattern.compile("[A-Z][a-z]+");
        Matcher m7 = p7.matcher(input);
        while (m7.find()) {
            System.out.println(m7.group());
        }

        System.out.println(input.matches("a.*b"));
    }
}