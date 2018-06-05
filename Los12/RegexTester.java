package Labs_OOP.Los12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class RegexTester {
        public static boolean testNameEvent(String testString){
            int length = testString.length();
            Pattern p = Pattern.compile("^[A-Z]{1}([a-zA-Z-']+)*$");
            Matcher m = p.matcher(testString);
            return m.matches();
        }

        public static boolean testDate(String testString) {
            Pattern p = Pattern.compile("[0-9]{2}+\\/+[0-9]{2}+\\/+[0-9]{4}");
            Matcher m = p.matcher(testString);
            return m.matches();
        }
        public static boolean testTime(String testString) {
            Pattern p = Pattern.compile("[0-9]{2}+\\:+[0-9]{2}");
            Matcher m = p.matcher(testString);
            return m.matches();
        }
    }

