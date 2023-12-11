public class Hamming {

    String leftStrand;
    String rightStrand;
    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }

    public int getHammingDistance() {
        int cont = 0;

        for (int i = 0; i < leftStrand.length(); i++){
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                cont++;
            }
        }

        return cont;
    }
}
