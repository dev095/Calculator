import java.util.List;

/**
 * Created by sergey on 14.11.2020
 */
class OutLine {
    static String outResult = "";

    public static String getOutResult() {
        return outResult;
    }

    public static String outLine(int number) {

        if (DetectRome.isRomeMarker ()) {
            List<RomeNumbers> romeNumbers = RomeNumbers.getSortedRome ();
            StringBuilder romeOutSb = new StringBuilder ();
            int i = 0;

            while (number > 0 && i < romeNumbers.size ()) {
                RomeNumbers now = romeNumbers.get (i);
                if (now.getValue () <= number) {
                    romeOutSb.append (now.name ());
                    number -= now.getValue ();
                } else {
                    i++;
                }
            }
            outResult = romeOutSb.toString ();

        } else {
            outResult = Calculate.getResult () + "";
        }
        return outResult;
    }
}
