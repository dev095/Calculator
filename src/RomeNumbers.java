import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sergey on 14.11.2020
 */ //RomeNumbers перечисления для вывода результата (если флаг romeMarker true)
enum RomeNumbers {
    I (1),
    IV (4),
    V (5),
    IX (9),
    X (10),
    XL (40),
    L (50),
    XC (90),
    C (100),
    CD (400),
    D (500),
    CM (900),
    M (1000);

    private final int value;

    RomeNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomeNumbers> getSortedRome() {
        return Arrays.stream (values ())
                .sorted (Comparator.comparing ((RomeNumbers e) -> e.value).reversed ())
                .collect (Collectors.toList ());
    }
}
