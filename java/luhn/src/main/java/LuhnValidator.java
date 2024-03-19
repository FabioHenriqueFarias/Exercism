import java.util.ArrayList;

class LuhnValidator {

    boolean isValid(String candidate) {

        candidate = candidate.replace(" ", "");

        if (candidate.length() <= 1) return false;
        ArrayList<Integer> set = new ArrayList<>();


        for(int i = 0; i < candidate.length(); i++){

            try {
                set.add(Integer.parseInt(String.valueOf(candidate.charAt(i))));
            } catch (NumberFormatException error) {
                return false;
            }

        }

        productOfSecondDigit(set);
        int sum = sumOfDigits(set);

        return sum % 10 == 0;
    }

    public void productOfSecondDigit(ArrayList<Integer> values){

        int size = values.size();

        for(int i = size - 2; i >= 0; i -=2){

            int value = values.get(i) * 2;
            if (value > 9) value -= 9;

            values.set(i, value);
        }
    }

    public int sumOfDigits(ArrayList<Integer> values){

        int sum = 0;

        for (Integer value : values) {

            sum += value;
        }

        return sum;
    }

}
