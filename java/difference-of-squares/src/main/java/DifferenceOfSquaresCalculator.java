class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
        }

        return (int) Math.pow(sum, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int pow = 0;
        for (int i = 1; i <= input; i++) {
            pow += (int) Math.pow(i, 2);
        }

        return pow;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
