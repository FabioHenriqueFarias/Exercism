
public class Say {

    static final String[] TENTHS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static final String[] UNITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Number " + number + " cannot be converted");
        }

        return sayIt(number);
    }
    private static String sayIt(long number){

        if (number >= 1_000_000_000) return from(number, 1_000_000_000, "billion");
        if (number >= 1_000_000) return from(number, 1_000_000, "million");
        if (number >= 1_000) return from(number, 1_000, "thousand");
        if (number >= 100) return from(number, 100, "hundred");
        if (number >= 20) return TENTHS[(int) (number / 10)] + ifNotZero(number % 10, "-");

        return UNITS[(int) number];
    }

    public static String ifNotZero(long number, String prefix){
        return number == 0 ? "" : prefix + sayIt(number);
    }

    private static String from(long number, long from, String name) {
        return sayIt(number/from) + " " + name + ifNotZero(number % from, " ");
    }

}
