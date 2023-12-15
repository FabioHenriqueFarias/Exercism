import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scrabble {

    String word;

    ArrayList<Character> characterValue_1 = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'));

    ArrayList<Character> characterValue_2 = new ArrayList<>(Arrays.asList('D', 'G'));
    ArrayList<Character> characterValue_3 = new ArrayList<>(Arrays.asList('B', 'C', 'M', 'P'));

    ArrayList<Character> characterValue_4 = new ArrayList<>(Arrays.asList('F', 'H', 'V', 'W', 'Y'));

    ArrayList<Character> characterValue_5 = new ArrayList<>(List.of('K'));
    ArrayList<Character> characterValue_8 = new ArrayList<>(Arrays.asList('J', 'X'));

    ArrayList<Character> characterValue_10 = new ArrayList<>(Arrays.asList('Q', 'Z'));

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        int soma = 0;

        for(char caractere : word.toCharArray()){
            int scoreCaractere = valueCaractere(caractere);
            soma += scoreCaractere;
        }

        return soma;
    }

    int valueCaractere(char caractere){

        if(characterValue_1.contains(caractere)) return 1;
        if(characterValue_2.contains(caractere)) return 2;
        if(characterValue_3.contains(caractere)) return 3;
        if(characterValue_4.contains(caractere)) return 4;
        if(characterValue_5.contains(caractere)) return 5;
        if(characterValue_8.contains(caractere)) return 8;
        if(characterValue_10.contains(caractere)) return 10;

        throw new IllegalArgumentException("Invalid character");
    }

}
