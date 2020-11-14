public class Main {
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


