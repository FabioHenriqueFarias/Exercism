import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;

class ResistorColorTrio {
    String label(String[] colors) {
        List<String> colorsValues = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));
        StringBuilder builder = new StringBuilder();
        long value = 0L;

        value = (long) ((colorsValues.indexOf(colors[0]) * 10 + colorsValues.indexOf(colors[1])) * Math.pow(10, colorsValues.indexOf(colors[2])));

        if (value > 1_000_000_000) {
            return String.format("%d %s", value / 1_000_000_000, "gigaohms");
        }
        if (value > 1_000_000) {
            return String.format("%d %s", value / 1_000_000, "megaohms");
        }
        if (value > 1_000) {
            return String.format("%d %s", value / 1_000, "kiloohms");
        }

    }
}
