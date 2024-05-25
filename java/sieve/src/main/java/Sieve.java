import java.util.*;

class Sieve {

    private int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= maxPrime; i++) {
            numbers.add(i);
        }

        int currentIndex = 0;
        while (currentIndex < numbers.size()) {
            int currentPrime = numbers.get(currentIndex);
            primes.add(currentPrime);

            numbers.removeIf(n -> n != currentPrime && n % currentPrime == 0);

            currentIndex++;
        }

        return primes;

    }
}
