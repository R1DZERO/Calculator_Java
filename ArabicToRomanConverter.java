public class ArabicToRomanConverter {
    public static String converter(int number) throws Exception {
        if (number < 0) {
            throw new Exception("Ошибка: в римской системе нет отрицательных чисел.");
        }

        StringBuffer result = new StringBuffer();
        int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        while (number > 0) {
            if (number >= arabic[i]) {
                result.append(roman[i]);
                number -= arabic[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }
}