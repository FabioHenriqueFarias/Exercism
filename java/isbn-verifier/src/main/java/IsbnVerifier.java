class IsbnVerifier {

    boolean isValid(String stringToVerify) {

       int value = 0;
       int sum = 0;
       stringToVerify = stringToVerify.replace("-", "");

        if(stringToVerify.length() != 10) {
            return false;
        }

        for(int i = 0; i < stringToVerify.length(); i++){
            char character = stringToVerify.charAt(i);

            if ((Character.isLetter(character) && character != 'X')) {
                return false;
            }

            if (character == 'X' && i != stringToVerify.length() - 1)  return false;

            value = (character == 'X') ? 10 : Character.getNumericValue(character);

            sum += value * (stringToVerify.length() - i);

        }

        return sum % 11 == 0;
    }
}
