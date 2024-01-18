import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ResistorColorDuo {
    int value(String[] colors) {

        List<String> colorsValues = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));

        StringBuilder builder = new StringBuilder();
        int value;
        int cont = 0;

        for (String color : colors) {

            int index = colorsValues.indexOf(color);
            if(index >= 0){
                builder.append(index);
                cont++;
            }

            if(cont >= 2){
                break;
            }

        }

        value = Integer.parseInt(builder.toString());

        return value;

    }
}






