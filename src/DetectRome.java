/**
 * Created by sergey on 14.11.2020
 */

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
