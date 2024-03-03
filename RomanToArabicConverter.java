import java.util.HashMap;
import java.util.Map;

public class RomanToArabicConverter {
    private static final Map<Character, Integer> romanToArabic = new HashMap<>();

    static {
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
    }

    public static int converter(String romanNumber) {
        int result = 0;
        int romanNumberLength = romanNumber.length();
        for (int i = 0; i < romanNumberLength; i++) {
            char currentChar = romanNumber.charAt(i);
            if (i < romanNumberLength - 1 && romanToArabic.get(currentChar) < romanToArabic.get(romanNumber.charAt(i + 1))) {
                result -= romanToArabic.get(currentChar);
            } else {
                result += romanToArabic.get(currentChar);
            }
        }
        return result;
    }
}