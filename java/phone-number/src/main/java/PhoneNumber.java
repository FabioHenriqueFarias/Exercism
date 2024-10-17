class PhoneNumber {

    String numberCell;

    PhoneNumber(String numberString) {
        this.numberCell = numberString;
        StringBuilder cleanedNumber = cleanNumber();
        validateNumber(cleanedNumber);
        this.numberCell = cleanedNumber.toString();
    }

    private StringBuilder cleanNumber() {
        StringBuilder sb = new StringBuilder();

        for (char character : this.numberCell.toCharArray()) {

            if (Character.isLetter(character)) {
                throw new IllegalArgumentException("letters not permitted");
            }

            if (character == '@' || character == '!' || character == ':' ){
                throw new IllegalArgumentException("punctuations not permitted");
            }

            if (Character.isDigit(character)) {
                sb.append(character);
            }
        }

        return sb;
    }

    private void validateNumber(StringBuilder number) {

        if (number.length() == 11) {
            if (number.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            number.deleteCharAt(0);
        }

        if (number.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if (number.length() > 10) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        checkAreaAndExchangeCodes(number);
    }

    private void checkAreaAndExchangeCodes(StringBuilder number) {

        if (number.charAt(0) == '1'){
            throw new IllegalArgumentException("area code cannot start with one");
        }

        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }

        if (number.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }

        if(number.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }

    String getNumber() {
        return this.numberCell;
    }

}