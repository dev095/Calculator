import java.util.Scanner;

/**
 * Created by sergey on 14.11.2020
 */ //InString class(получаем входную строку и проверяем на условия задания)
class InString {
    static String inStr;

    public static String getInStr() {
        return inStr;
    }

    static void inLine() {
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.println ("Введите выражения в формате  \"a+b\"\nЧисла от 1 до 10 (от I до X)");
            inStr = scanner.nextLine ().replaceAll ("\\s+", "").toUpperCase ();
        } while (inStr.length () == 0);
    }

}
