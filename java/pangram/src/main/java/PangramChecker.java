public class PangramChecker {

    public boolean isPangram(String input) {

        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            char caractere = input.charAt(i);

            if((sb.indexOf(String.valueOf(caractere)) == -1) && Character.isLetter(caractere)){
                sb.append(caractere);
            }
        }

        return sb.length() == 26;
    }

}
