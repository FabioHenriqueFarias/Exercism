import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char character) {
        int initialValue, finalValue, difference;
        List<String> diamondList = new ArrayList<String>();


        if (character == 'A') {
            diamondList.add(String.valueOf(character));
            return diamondList;
        }

        initialValue = (int) 'A';
        finalValue = (int) character;
        difference = finalValue - initialValue;

        String outer_spaces = new String(new char[difference]).replace('\0', ' ');


        String inner_spaces = " ";

        diamondList.add(outer_spaces + "A" + outer_spaces);

        for(char letter = 'B';  letter != character + 1; letter++) {
            outer_spaces =  outer_spaces.length() > 1 ?  outer_spaces.substring(0, outer_spaces.length()-1) : "";
            String row = outer_spaces + letter + inner_spaces + letter + outer_spaces;
            inner_spaces += "  ";
            diamondList.add(row);
        }

        for(int index = difference -1;index >= 0; index--) {
            diamondList.add(diamondList.get(index));
        }


        return diamondList;

    }

}
