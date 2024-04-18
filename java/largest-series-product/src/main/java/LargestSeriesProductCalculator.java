import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {

    String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException("String to search may not be null.");
        }
        if (!inputNumber.matches("\\d*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (inputNumber.isEmpty() && numberOfDigits > 0) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if(numberOfDigits < 0){
        throw new IllegalArgumentException("Series length must be non-negative.");
        }

        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        List<List<String>> listCombinations = getDigits(numberOfDigits);
        List<Long> results = new ArrayList<>();

        for (List<String> list : listCombinations) { // Corrigido para iterar sobre List<String>
            long product = 1;
            for (String str : list) { // Iterar sobre cada String na List<String>
                for (char caracter : str.toCharArray()) { // Iterar sobre cada caractere na String
                    long value = Character.getNumericValue(caracter);
                    product *= value;
                }
            }
            results.add(product);
        }



        return results.stream()
                .max(Long::compareTo)
                .get();
    }

    List<List<String>> getDigits(int numberOfDigits) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            int next = i + numberOfDigits;
            if (next > inputNumber.length()) {
                break;
            }
            String value = inputNumber.substring(i, next);

            List<String> lista = new ArrayList<>();
            lista.add(value);

            if(result.contains(lista)){
                continue;
            }

            result.add(lista);
        }

        for (int i = result.size(); i > 0; i--) {
            int next = i - numberOfDigits;
            if (next < inputNumber.length()) {
                break;
            }
            String value = inputNumber.substring(i, next);

            List<String> lista = new ArrayList<>();
            lista.add(value);

            if(result.contains(lista)){
                continue;
            }

            result.add(lista);
        }

        return result;
    }
}
