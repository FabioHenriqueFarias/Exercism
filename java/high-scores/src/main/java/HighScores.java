import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HighScores {

    List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return this.highScores;
    }

    Integer latest() {
        return this.highScores.get(this.highScores.size() - 1);
    }

    Integer personalBest() {
        return Collections.max(this.highScores);
    }

    List<Integer> personalTopThree() {
        List<Integer> listCopy = new ArrayList<Integer>(this.highScores);
        List<Integer> topThreeValues = new ArrayList<Integer>();

        int quantityIndice = 3;

        if(listCopy.size() < quantityIndice){
            quantityIndice = listCopy.size();
        }
            for(int i = 0; i < quantityIndice; i++) {
                Integer value = Collections.max(listCopy);
                topThreeValues.add(value);
                listCopy.remove(value);
            }

            return topThreeValues;

    }

}
