import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {

        if (phrase == null) return false;

        Set<Character> characterSet = new HashSet<>();

        for (char character : phrase.toCharArray()) {
            
            if (character == ' ' || character == '-') {
                continue;
            }

            character = Character.toUpperCase(character);

            if (!characterSet.add(character)) {
                return false;
            }
        }

        return true;
    }

}
