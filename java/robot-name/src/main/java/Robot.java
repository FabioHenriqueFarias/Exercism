import java.util.*;

class Robot {

    private static final Set<String> existingNames = new HashSet<>();


    List<Character> alphabet = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    );

    Random rand = new Random();

    String name;

    public Robot() {
        this.name = generateUniqueRandomName();
    }

    String getName() {
        return name;
    }

    private String generateUniqueRandomName() {
        String newName;
        do {
            newName = generateRandomName();
        } while (existingNames.contains(newName));
        existingNames.add(newName);
        return newName;
    }



    private String generateRandomName() {
        StringBuilder nameBuilder = new StringBuilder();

        nameBuilder.append(getRandomAlphabet());
        nameBuilder.append(getRandomAlphabet());
        nameBuilder.append(getRandomNumber());

        this.name = nameBuilder.toString();

        return name;
    }

    void reset() {
        name = generateUniqueRandomName();
    }

    private char getRandomAlphabet() {
        int index = rand.nextInt(26); // A-Z
        return (char) ('A' + index);
    }

    public String getRandomNumber() {
        int min = 0;
        int max = 999;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.format("%03d", randomNumber);
    }



}