import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String firstVar;
        String secondVar;
        String operator;
        userInputHandler(userInput);
        String[] userInputSeparated = userInput.split(" ");
        firstVar = userInputSeparated[0];
        secondVar = userInputSeparated[2];
        operator = userInputSeparated[1];
        System.out.println(calculate(firstVar, operator, secondVar));
    }

    public static void userInputHandler(String userInput) throws Exception {
        String[] userInputSeparated = userInput.split(" ");

        if (userInputSeparated.length != 3) {
            throw new Exception("Калькулятор может выполнить операцию только с двумя операндами.");
        }
        String firstVar = userInputSeparated[0];
        String secondVar = userInputSeparated[2];
        if (isRomanNum(firstVar) && isRomanNum(secondVar)) {
            firstVar = String.valueOf(RomanToArabicConverter.converter(firstVar));
            secondVar = String.valueOf(RomanToArabicConverter.converter(secondVar));
        }
        if (isRomanNum(firstVar) != isRomanNum(secondVar)) {
            throw new Exception("Калькулятор поддерживает операции только для операндов одного формата (арабского или римского) и только с целочисленными значениями.");
        }
        if ((Integer.parseInt(firstVar) < 1 || Integer.parseInt(firstVar) > 10) || (Integer.parseInt(secondVar) < 1 || Integer.parseInt(secondVar) > 10)) {
            throw new Exception("Калькулятор не принимает на ввод значения меньше 1 и больше 10.");
        }
    }

    public static boolean isRomanNum(String symbol) {
        return symbol.charAt(0) == 'I' || symbol.charAt(0) == 'V' || symbol.charAt(0) == 'X';
    }

    public static String calculate(String firstVar, String operator, String secondVar) throws Exception {
        int firstCharInt;
        int secondCharInt;
        int result;
        if (isRomanNum(firstVar) && isRomanNum(secondVar)) {
            firstCharInt = RomanToArabicConverter.converter(firstVar);
            secondCharInt = RomanToArabicConverter.converter(secondVar);
            switch (operator) {
                case "+":
                    result = firstCharInt + secondCharInt;
                    break;
                case "-":
                    result = firstCharInt - secondCharInt;
                    break;
                case "*":
                    result = firstCharInt * secondCharInt;
                    break;
                case "/":
                    result = firstCharInt / secondCharInt;
                    break;
                default:
                    throw new Exception("Неподдерживаемый оператор");
            }
            return ArabicToRomanConverter.converter(result);
        }
        firstCharInt = Integer.parseInt(firstVar);
        secondCharInt = Integer.parseInt(secondVar);
        switch (operator) {
            case "+":
                result = firstCharInt + secondCharInt;
                break;
            case "-":
                result = firstCharInt - secondCharInt;
                break;
            case "*":
                result = firstCharInt * secondCharInt;
                break;
            case "/":
                result = firstCharInt / secondCharInt;
                break;
            default:
                throw new Exception("Неподдерживаемый оператор");
        }
        return String.valueOf(result);
    }
}