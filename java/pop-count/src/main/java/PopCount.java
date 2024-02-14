public class PopCount {
    public int eggCount(int number) {
        String binaryRepresentation = Integer.toBinaryString(number);

        return calculateEggs(binaryRepresentation);
    }

    int calculateEggs(String binaryRepresentation){

        int count = 0;
        char caractere = '1';

        for(int i = 0; i < binaryRepresentation.length(); i++){
            if(binaryRepresentation.charAt(i) == caractere){
                count ++;
            }
        }

        return count;
    }
}
