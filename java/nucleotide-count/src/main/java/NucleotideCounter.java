import java.util.Map;

class NucleotideCounter {

    String sequence;

    NucleotideCounter(String sequence) {
        this.sequence = sequence.trim().toUpperCase();

        if(!isValidNucleotide()) {
            throw new IllegalArgumentException("Invalid nucleotide in DNA sequence");
        }
    }

    Map<Character, Integer> nucleotideCounts() {

        Map<Character, Integer> nucleotideCount = new java.util.HashMap<>(Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));

        for(char nucleotide : this.sequence.toCharArray()) {
            nucleotideCount.put(nucleotide, nucleotideCount.get(nucleotide) + 1);
        }

        return nucleotideCount;

    }

    private boolean isValidNucleotide() {

        if (this.sequence == null) {
            return false;
        }

        for (char nucleotide : this.sequence.toCharArray()) {
            if (nucleotide != 'A' && nucleotide != 'C' && nucleotide != 'G' && nucleotide != 'T') {
                return false;
            }
        }

        return true;
    }

}