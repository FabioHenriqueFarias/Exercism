import java.util.HashMap;
import java.util.Map;

class TwelveDays {

    private static final Map<Integer, String> ordinals = new HashMap<>();
    private static final Map<Integer, String> gifts = new HashMap<>();


    static {
        ordinals.put(1, "first");
        ordinals.put(2, "second");
        ordinals.put(3, "third");
        ordinals.put(4, "fourth");
        ordinals.put(5, "fifth");
        ordinals.put(6, "sixth");
        ordinals.put(7, "seventh");
        ordinals.put(8, "eighth");
        ordinals.put(9, "ninth");
        ordinals.put(10, "tenth");
        ordinals.put(11, "eleventh");
        ordinals.put(12, "twelfth");

        gifts.put(1, "a Partridge in a Pear Tree.");
        gifts.put(2, "two Turtle Doves, and");
        gifts.put(3, "three French Hens,");
        gifts.put(4, "four Calling Birds,");
        gifts.put(5, "five Gold Rings,");
        gifts.put(6, "six Geese-a-Laying,");
        gifts.put(7, "seven Swans-a-Swimming,");
        gifts.put(8, "eight Maids-a-Milking,");
        gifts.put(9, "nine Ladies Dancing,");
        gifts.put(10, "ten Lords-a-Leaping,");
        gifts.put(11, "eleven Pipers Piping,");
        gifts.put(12, "twelve Drummers Drumming,");
    }


    String verse(int verseNumber) {
        StringBuilder verse = new StringBuilder();
        verse.append(String.format("On the %s day of Christmas my true love gave to me: ", ordinals.get(verseNumber)));

        for (int i = verseNumber; i >= 1; i--) {
            if (i == verseNumber) {
                verse.append(gifts.get(i));
                continue;
            }
            verse.append(" ").append(gifts.get(i));

        }

        verse.append("\n");

        return verse.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verse = new StringBuilder();

        for (int i = startVerse; i <= endVerse ; i++) {
            verse.append(String.format("On the %s day of Christmas my true love gave to me: ", ordinals.get(i)));
            for (int j = i; j > 0; j--) {
                if (j == i){
                    verse.append(gifts.get(i));
                    continue;
                }
                verse.append(" ").append(gifts.get(j));
            }

            if (i < endVerse) {
                verse.append("\n\n");
            } else {
                verse.append("\n");
            }
        }

        return verse.toString();

    }

    String sing() {
        return verses(1,12);
    }
}
