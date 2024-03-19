import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        generateCombinations(cageSum,  cageSize, 1, new ArrayList<>(), combinations, exclude);

        return combinations;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }


    public void generateCombinations(Integer cageSum, Integer cageSize, int start, List<Integer> currentCombinations,List<List<Integer>> combinations, List<Integer> exclude){
        if (cageSize == 0 && cageSum == 0) {
            combinations.add(new ArrayList<>(currentCombinations));
            return;
        }

        for (int i = start; i <= 9; i++) {
            // Check if the number is already on the exclusion list
            if (!exclude.contains(i)) {
                // Add the number to the current combination
                currentCombinations.add(i);
                // Call recursively with one less number in the sum and quantity
                generateCombinations(cageSum - i, cageSize - 1, i + 1, currentCombinations, combinations, exclude);
                // Remove the last added number to explore other combinations
                currentCombinations.remove(currentCombinations.size() - 1);
            }
        }

    }

}
