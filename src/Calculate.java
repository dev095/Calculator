/**
 * Created by sergey on 14.11.2020
 */

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
