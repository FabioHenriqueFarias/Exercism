import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {



    List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> primeFactors = new ArrayList<Long>();

        while (number % 2 == 0) {
            primeFactors.add(2L);
            number /= 2;
        }

        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }

}