import java.util.ArrayList;
import java.util.List;

class Allergies {

    private int score;
    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) != 0;
    }

    public List<Allergen> getList() {
        List<Allergen> allergens = new ArrayList<>();

        for (Allergen allergen : Allergen.values()) {
            if (isAllergicTo(allergen)) {
                allergens.add(allergen);
                score -= allergen.getScore();
            }
        }

        return allergens;
    }

    public int getScore() {
        return score;
    }
}
