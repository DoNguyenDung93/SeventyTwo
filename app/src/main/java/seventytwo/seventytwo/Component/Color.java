package seventytwo.seventytwo.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by dongu on 10/12/2015.
 * This enum contains the 6 types of color on tokens.
 */
public enum Color {
    RED, BLUE, GREEN, YELLOW, PINK, CYAN;

    private static final List<Color> COLORS_LIST = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = COLORS_LIST.size();
    private static final Random RANDOM = new Random();

    public static Color getRandomColor() {
        return COLORS_LIST.get(RANDOM.nextInt(SIZE));
    }
}
