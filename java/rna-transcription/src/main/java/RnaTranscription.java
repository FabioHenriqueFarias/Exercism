class RnaTranscription {

    String transcribe(String dnaStrand) {

        StringBuilder rnaStrandBuilder = new StringBuilder();

        for (int i = 0; i < dnaStrand.length(); i++){
            char currentChar = dnaStrand.charAt(i);

            switch (currentChar){
                case 'G':
                    rnaStrandBuilder.append("C");
                    break;
                case 'C':
                    rnaStrandBuilder.append("G");
                    break;
                case 'T':
                    rnaStrandBuilder.append("A");
                    break;
                case 'A':
                    rnaStrandBuilder.append("U");
                    break;
            }
        }

        return rnaStrandBuilder.toString();
    }
}
