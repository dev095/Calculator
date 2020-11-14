/**
 * Created by sergey on 14.11.2020
 */

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
        String[] arg = InString.getInStr ().split ("[+-/*]");
        arg1 = arg[0];
        arg2 = arg[1];
    }

    public static void detectOperator() {
        operator = InString.getInStr ().replaceAll ("[^-+*/]", "");
    }
}
