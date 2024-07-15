import java.util.ArrayList;
import java.util.List;

class Atbash {

    List<Character> alphabet = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    List<Character> reversedAlphabet = List.of('z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
            'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a');

    String encode(String input) {
        StringBuilder phrase = new StringBuilder();

        input.toLowerCase().chars().
                mapToObj(c -> (char) c).
                forEach(caractere -> {
                    int index = alphabet.indexOf(caractere);
                    if (index != -1) {
                        phrase.append(reversedAlphabet.get(index));
                    }else{
                        if (Character.isDigit(caractere)) {
                            phrase.append(caractere);
                        }
                    }
                });

        StringBuilder phraseWithSpaces = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (i % 5 == 0 && i != 0) {
                phraseWithSpaces.append(" ");
            }
            phraseWithSpaces.append(c);
        }


        return phraseWithSpaces.toString();
    }

    String decode(String input) {
        StringBuilder phrase = new StringBuilder(input);

        phrase.chars().
                mapToObj(c -> (char) c).
                forEach(caractere -> {
                    if (Character.isWhitespace(caractere)) {
                        phrase.deleteCharAt(phrase.indexOf(" "));
                    }
               });

        StringBuilder phraseWithoutSpaces = new StringBuilder();

        phrase.toString().toLowerCase().chars().
                mapToObj(c -> (char) c).
                forEach(caractere -> {
                    int index = reversedAlphabet.indexOf(caractere);
                    if (index != -1) {
                        phraseWithoutSpaces.append(alphabet.get(index));
                    }else{
                        if (Character.isDigit(caractere)) {
                            phraseWithoutSpaces.append(caractere);
                        }
                    }
                });

        return phraseWithoutSpaces.toString();
    }

}
