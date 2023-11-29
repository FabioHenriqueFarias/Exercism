import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(10)];
    }

    String randomShipRegistryNumber() {
        int randomNumber = random.nextInt(9000) + 1000;
        return String.format("NCC-%d", randomNumber);
    }

    double randomStardate() {
        return random.nextDouble(42000-41000) + 41000;
    }
}
