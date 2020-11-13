import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        InString.inLine();
        Detect.detectArguments();
        int a = Integer.parseInt(Detect.getArguments()[0]);
        int b = Integer.parseInt(Detect.getArguments()[1]);
        System.out.println(a + "???" + b);
        double result = Calculate.calculate(Detect.getArguments(),Detect.getOperator());
        System.out.println("Результат: " + result);
    }
}

class InString {
    static String inLine() {
        Scanner scanner = new Scanner(System.in);
        String inStr;
        do {
            System.out.println("Введите выражения в формате  \"a+b\"");
            inStr = scanner.nextLine().replaceAll("\\s+", "").toUpperCase();
        } while (inStr.length() == 0);
        return inStr;
    }
}

class Detect {
    private static final String operator = detectOperator();

    private static final String[] arguments = detectArguments();

    public static String[] getArguments() {
        return arguments;
    }

    public static String getOperator() {
        return operator;
    }


    protected static String[] detectArguments() {
        String[] arguments = InString.inLine().split("[+-/*]");
        System.out.println("аргументы: " + Arrays.toString(arguments) + ", " + "оператор: " + operator);
        return arguments;
    }
    private static String detectOperator(){
        return InString.inLine().replaceAll("[^-+*/]", "");
    }
}

class Calculate {
    private static int result;

    static double calculate(String[] strings, String operator) {
        int arg1 = Integer.parseInt(strings[0]);
        int arg2 = Integer.parseInt(strings[1]);

        System.out.println(arg1 + "///" + arg2 + "///" + operator);

        switch (operator) {
            case ("+") -> result = arg1 + arg2;
            case ("-") -> result = arg1 - arg2;
            case ("*") -> result = arg1 * arg2;
            case ("/") -> result = arg1 / arg2;
            default -> System.out.println ("Оператор не определен! Повторите ввод.");
        }
        return result;
    }
}


//enum RomanNumbers {
//    I(1), II(2), III(3), IV(4), V(5),
//    VI(6), VII(7), VIII(8), IX(9), X(10),
//    XX(20), XXX(30), XL(40), L(50), LX(60),
//    LXX(70), LXXX(80), XC(90), C(100);
//
//    private int value;
//
//    RomanNumbers(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
//}
