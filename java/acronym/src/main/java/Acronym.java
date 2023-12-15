import java.util.ArrayList;
import java.util.List;

class Acronym {

    String phrase;
    List<Integer> indicesEspacos = new ArrayList<>();

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder phraseReplace = new StringBuilder();

        String[] words = phrase.toUpperCase().replace('_','-').split("[\\s ,-]+");

        for (String word : words) {
            phraseReplace.append(word.charAt(0));
        }

        return phraseReplace.toString();
    }

}





