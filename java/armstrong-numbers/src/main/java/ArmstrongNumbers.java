class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String numberString = String.valueOf(numberToCheck);
        int result = 0;
        for(int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            result += Math.pow(digit, numberString.length());
        }

        return result == numberToCheck;

    }

}
