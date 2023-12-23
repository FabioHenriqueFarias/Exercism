import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    int[] abilities;

    DnDCharacter(){
        this.abilities = new int[6];
        initGame();
    }

    void initGame(){
        for (int i = 0; i < 6; i++){
            this.abilities[i] = ability(rollDice());
        }
    }

    int ability(List<Integer> scores) {

        int sumAbilities = 0;

        int lowerValue =  findLowestValue(scores);

        List<Integer> mutableScores = new ArrayList<>(scores);
        mutableScores.remove(Integer.valueOf(lowerValue));

        for(int value : mutableScores) {
            sumAbilities += value;
        }

        return sumAbilities;
    }

    List<Integer> rollDice() {
        Random random = new Random();

        List<Integer> dice = new ArrayList<Integer>();

        for(int i = 0; i < 4; i++) {
            dice.add(random.nextInt(6) + 1);
        }

        return dice;
    }

    int modifier(int input) {
        double number =  ((input - 10) /2.0);
        if(number < 0){
            number = -1 * number;
            return  - 1 * (int)Math.ceil(number);
        }else{
            return (int) number;
        }
    }

    int getStrength() {
        return abilities[0];
    }

    int getDexterity() {
        return abilities[1];
    }

    int getConstitution() {
        return abilities[2];
    }

    int getIntelligence() {
        return abilities[3];
    }

    int getWisdom() {
        return abilities[4];
    }

    int getCharisma() {
        return abilities[5];
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }



    int findLowestValue(List<Integer> ability){
        int menorValor = ability.get(0);

        for (int valor : ability) {
            if (valor < menorValor) {
                menorValor = valor;
            }
        }

        return menorValor;
    }

}
