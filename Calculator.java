import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String firstVar;
        String secondVar;
        String operator;
        String error;
        error = userInputHandler(userInput);
        if (!error.isEmpty()) {
            System.out.println(error);
            System.exit(0);
        }
        String[] userInputSeparated = userInput.split(" ");
        firstVar = userInputSeparated[0];
        secondVar = userInputSeparated[2];
        operator = userInputSeparated[1];
        System.out.println(calculate(firstVar, operator, secondVar));
    }

    public static String userInputHandler(String userInput) {
        String[] userInputSeparated = userInput.split(" ");
        if (userInputSeparated.length != 3) {
            return ("Калькулятор может выполнить операцию только с двумя операндами.");
        }
        String firstVar = userInputSeparated[0];
        String secondVar = userInputSeparated[2];
        if (isRomanNum(firstVar) != isRomanNum(secondVar) || isNumInt(firstVar) != isNumInt(secondVar)) {
            return ("Калькулятор поддерживает операции только для операндов одного формата (арабского или римского) и только с целочисленными значениями.");
        }
        return "";
    }

    public static boolean isNumInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isRomanNum(String symbol) {
        return symbol.charAt(0) == 'I' || symbol.charAt(0) == 'V' || symbol.charAt(0) == 'X';
    }

    public static String calculate(String firstVar, String operator, String secondVar) {
        int firstCharInt;
        int secondCharInt;
        int result = 0;
        String error = "";
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
                    error = "Неподдерживаемый оператор";
            }
            return ArabicToRomanConverter.converter(result);
        } else if (isNumInt(firstVar) && isNumInt(secondVar)) {
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
                    error = "Неподдерживаемый оператор";
            }
        }
        if (!error.isEmpty()) {
            return error;
        } else {
            return String.valueOf(result);
        }
    }
}