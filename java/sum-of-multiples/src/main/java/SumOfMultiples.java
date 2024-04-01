import java.util.*;

class SumOfMultiples {

    int number;
    int[] set;
    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        List<Integer> setMultiples = new ArrayList<>();
        int sum = 0;

        for(int i : set) {
           setMultiples.addAll(calculateSets(i));
        }

        setMultiples = removeDuplicates(setMultiples);

        for(int i : setMultiples) {
            sum += i;
        }

        return sum;

    }

    private ArrayList<Integer> calculateSets(int i) {
        ArrayList<Integer> multiples = new ArrayList<>();
        for(int j = 1; j < number; j++){

            if(i == 0) {
                continue;
            }

            if(j % i == 0) {
                multiples.add(j);
            }
        }

        return multiples;
    }

    public static <T> List<T> removeDuplicates(List<T> multiples) {
        Set<T> set = new HashSet<>(multiples);
        return new ArrayList<>(set);
    }

}
