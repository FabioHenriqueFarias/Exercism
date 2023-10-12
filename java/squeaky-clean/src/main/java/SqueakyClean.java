import java.lang.StringBuilder;

class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder newIdentifier = new StringBuilder(identifier);


        if(identifier.indexOf(' ') >= 0){
            return replacesBlankSpace(newIdentifier);
        }

        if(identifier.indexOf('-') >= 0){
            return convertKebabCaseToCamelCase(newIdentifier);
        }

        convertISOControlChars(newIdentifier);
        removeGreekCharacters(newIdentifier);
        removeCharactersNotLetters(newIdentifier);

        for(int i = newIdentifier.length() - 1; i >= 0; i--){

            char currentChar = newIdentifier.toString().charAt(i);

            if(!Character.isISOControl(currentChar) ){
                newIdentifier.deleteCharAt(i);
            }
            }
        // Teste 4

        return newIdentifier.toString();
    }

    public static void convertISOControlChars(StringBuilder identifier){
        for(int i = 0; i < identifier.length(); i++){
            if(Character.isISOControl(identifier.toString().charAt(i))){
                identifier.replace(i, i + 1, "CTRL");
            }
        }
    }

    public static String replacesBlankSpace(StringBuilder identifier) {
        int indice;
        while (identifier.toString().indexOf(' ') != -1){
            indice = identifier.toString().indexOf(' ');
            identifier.setCharAt(indice, '_');
        }

        return identifier.toString();
    }

    public static void removeCharactersNotLetters(StringBuilder identifier){
        for(int i = identifier.length() - 1; i >= 0; i--) {
            char currentChar = identifier.toString().charAt(i);

            if(!Character.isLetter(currentChar)){
                identifier.deleteCharAt(i);
            }
        }
    }

    public static String convertKebabCaseToCamelCase(StringBuilder identifier) {
        int indice;
        while (identifier.toString().indexOf('-') != -1){
            indice = identifier.toString().indexOf('-');
            if(Character.isDigit(identifier.charAt(indice + 1))){
                identifier.deleteCharAt(indice + 1);
            }
            identifier.setCharAt(indice, Character.toUpperCase(identifier.charAt(indice + 1)));
            identifier.deleteCharAt(indice + 1 );
        }

        return identifier.toString();
    }

    public static void removeGreekCharacters(StringBuilder identifier) {
        for(int i = identifier.length() - 1; i >= 0; i--) {
            if(isGreekLetter(identifier.charAt(i))){
                identifier.deleteCharAt(i);
            }
        }
    }
    public static boolean isGreekLetter(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);

        return (block == Character.UnicodeBlock.GREEK || block == Character.UnicodeBlock.GREEK_EXTENDED) ;
    }


}


