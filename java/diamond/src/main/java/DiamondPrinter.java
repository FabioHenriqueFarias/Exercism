import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    int initialValue;
    int finalValue;

    int difference;

    List<String> printToList(char a) {
        List<String> diamondList = new ArrayList<String>();
        a = Character.toUpperCase(a);

        if (a == 'A') {
            diamondList.add(String.valueOf(a));
            return diamondList;
        }

        this.initialValue = (int) 'a';
        this.finalValue = (int) a;
        this.difference = this.finalValue - initialValue;

        diamondList.add(stringMaker());
        initialValue++;

        while (initialValue < finalValue) {

            diamondList.add(stringMaker());
            initialValue ++;
        }

        finalValue = (int) 'a';

        while (initialValue > finalValue) {

            diamondList.add(stringMaker());
            initialValue --;
        }

        diamondList.add(stringMaker());

        return diamondList;
    }

    String stringMaker(){
        StringBuilder diamondString = new StringBuilder();
        String space = String.valueOf(' ').repeat(this.difference);

        diamondString.append(space);
        difference--;


        return diamondString.toString();
    }

}
