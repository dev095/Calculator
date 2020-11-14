import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        InString.inLine ();
        Detect.detectArguments ();
        Detect.detectOperator ();
        DetectRome.detectRome ();
        Calculate.calculate ();
        OutLine.outLine ();
        System.out.println ("Результат: " + OutLine.getOutResult ());
    }
}

//InString class(получаем входную строку и проверяем на условия задания)
class InString {
    static String inStr;

    public static String getInStr() {
        return inStr;
    }
    static void inLine() {
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.println ("Введите выражения в формате  \"a+b\"");
            inStr = scanner.nextLine ().replaceAll ("\\s+", "").toUpperCase ();
        } while (inStr.length () == 0);
    }

}


//Class Detect(определяем 2 аргумента и оператор)
class Detect {
    static String operator;

    public static String getOperator() {
        return operator;
    }

    static String arg1;
    static String arg2;

    public static String getArg1() {
        return arg1;
    }

    public static String getArg2() {
        return arg2;
    }

    public static void detectArguments() {
        String[] arg =  InString.getInStr ().split ("[+-/*]");
        arg1 = arg[0];
        arg2 = arg[1];
    }

    public static void detectOperator() {
        operator = InString.getInStr ().replaceAll ("[^-+*/]", "");
    }
}


//class DetectRome (определяем наличие римских цифр и выставляем флаг для  вывода результата)
class DetectRome {
    static String inString = InString.getInStr ();
    static int indexNum1;
    static int indexNum2;
    static boolean romeMarker;

    public static boolean isRomeMarker() {
        return romeMarker;
    }

    public static int getIndexNum1() {
        return indexNum1;
    }

    public static int getIndexNum2() {
        return indexNum2;
    }

    static void detectRome() {
        String[] romeNumbers = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        if (inString.contains (romeNumbers[1]) || inString.contains (romeNumbers[5]) || inString.contains (romeNumbers[10])) {
            romeMarker = true;
            try {
                for (int i = 0; i < romeNumbers.length; i++) {
                    if (romeNumbers[i].equals (Detect.getArg1 ())) indexNum1 = i;
                    if (romeNumbers[i].equals (Detect.getArg2 ())) indexNum2 = i;
                }
                for (int i = 0; i < 10; i++) {
                    if (Detect.getArg1 ().contains (String.valueOf (i)) || Detect.getArg2 ().contains (String.valueOf (i))) {
                        System.out.println ("Ошибка, присутствуют несовместимые типы аргументов.");
                        System.exit (0);
                    }
                }
            } catch (Exception e) {
                System.out.println (e.getMessage ());
            }
        } else {
            try {
                indexNum1 = Integer.parseInt (Detect.getArg1 ());
                indexNum2 = Integer.parseInt (Detect.getArg2 ());
            } catch (Exception e) {
                System.out.println (e.getMessage ());
            }
        }
    }
}


//Calculate class  вычисляем результат

class Calculate {
    static int arg1 = DetectRome.getIndexNum1 ();
    static int arg2 = DetectRome.getIndexNum2 ();
    static String operator = Detect.getOperator ();

    static int result;

    public static int getResult() {
        return result;
    }

    static void calculate() {
        switch (operator) {
            case ("+") -> result = arg1 + arg2;
            case ("-") -> result = arg1 - arg2;
            case ("*") -> result = arg1 * arg2;
            case ("/") -> result = arg1 / arg2;
        }
    }
}


class OutLine{
    static RomeNumbers[] romeNum = RomeNumbers.values ();

    public static RomeNumbers[] getRomeNum() {
        return romeNum;
    }

    static String outResult;
    public static String getOutResult() {
        return outResult;
    }

    static void outLine(){
        if(DetectRome.isRomeMarker ()){
            outResult = "V";
            System.out.println ("rome flag on");
        } else {
            outResult = Calculate.getResult () + "";
        }
    }
}

//RomeNumbers перечисления для вывода результата (если флаг romeMarker true)
enum RomeNumbers {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10),
    XX(20), XXX(30), XL(40), L(50), LX(60),
    LXX(70), LXXX(80), XC(90), C(100);

    private int value;

    RomeNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
