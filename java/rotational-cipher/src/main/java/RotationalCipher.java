class RotationalCipher {

    int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < data.length(); i++){
            char value = (char) data.charAt(i);
            int ascii = (int) value;
            if (!((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))){
                result.append(value);
                continue;
            }
            if (ascii >= 65 && ascii <= 90) {
                ascii += this.shiftKey;
                if (ascii > 90) ascii -= 26;
            }
            if (ascii >= 97 && ascii <= 122) {
                ascii += this.shiftKey;
                if (ascii > 122) ascii -= 26;
            }
            char newChar = (char) ascii;

            result.append(newChar);
        }


        return result.toString();
    }

}
