class PrimeCalculator {

    int nth(int nth) {

        int count = 0;
        int num = 0;

        if(nth < 1) {
            throw new IllegalArgumentException();
        }

        while (count < nth) {

            num++;

            if (isPrime(num)) {
                count++;
            }
        }

        return num;
    }

    boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num <= 1 || num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


}
