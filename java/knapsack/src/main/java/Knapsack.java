import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        List<Integer> values = new ArrayList<>();
        List<List<Item>> combinations = new ArrayList<>();

        int n = items.size();

        // Faz todas as combinações possíveis
        for (int i = 0; i < (1 << n); i++) {
            List<Item> combination = new ArrayList<>();
            int totalWeight = 0;
            int totalValue = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    Item currentItem = items.get(j);
                    totalWeight += currentItem.weight;
                    totalValue += currentItem.value;
                }
            }

            // Verificar se a combinação é válida
            if (totalWeight <= maximumWeight) {
                combinations.add(combination);
                values.add(totalValue);  // Armazenar o valor total das combinações válidas
            }
        }


        for(int i = 0; i < combinations.size(); i++){
            // passar todas as combinações e achar qual combinação dara o maior value
            int value = 0;
            for(int j = 0; j < combinations.get(i).size(); j++){
                value += combinations.get(i).get(j).value;
            }
            values.add(value);
        }

        return values.isEmpty() ? 0 : Collections.max(values);
    }

}