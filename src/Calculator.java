import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    public static void main(String[] args) {
        InString.inLine ();
        Detect.detectArguments ();
        Detect.detectOperator ();
        DetectRome.detectRome ();
        Calculate.calculate ();
        OutLine.outLine (Calculate.getResult ());
        System.out.println ("Результат: " + OutLine.getOutResult ());
    }
}


//Calculate class  вычисляем результат


