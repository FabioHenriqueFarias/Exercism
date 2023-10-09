class ReverseString {

    String reverse(String inputString) {
        String output = "";
        for (int i = inputString.length() - 1; i >= 0; i--){
             output += inputString.charAt(i);
        }

        return output;
    }
  
}
