import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Yacht {

    int[] dices;
    YachtCategory category;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dices = dice;
        this.category = yachtCategory;
    }

    int score() {

        int score = 0;
        List<Integer> scores = Arrays.stream(dices)
                .boxed()
                .toList();

        score = switch (category) {
            case YACHT -> {
                Map<Integer, Long> freqs = scores.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                boolean hasYacht = freqs.values().stream().anyMatch(count -> count == 5);
                yield hasYacht ? 50 : 0;

            }
            case ONES ->  scores.stream()
                    .filter(value -> value == 1)
                    .mapToInt(Integer::intValue)
                    .sum();
            case TWOS -> scores.stream()
                    .filter(value -> value == 2)
                    .mapToInt(Integer::intValue)
                    .sum();
            case THREES -> scores.stream()
                    .filter(value -> value == 3)
                    .mapToInt(Integer::intValue)
                    .sum();
            case FOURS -> scores.stream()
                    .filter(value -> value == 4)
                    .mapToInt(Integer::intValue)
                    .sum();
            case FIVES -> scores.stream()
                    .filter(value -> value == 5)
                    .mapToInt(Integer::intValue)
                    .sum();
            case SIXES -> scores.stream()
                    .filter(value -> value == 6)
                    .mapToInt(Integer::intValue)
                    .sum();
            case FULL_HOUSE -> {
                Map<Integer, Long> freqs = scores.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                OptionalInt sumTwoFreqs = freqs.entrySet().stream()
                        .filter(entry -> entry.getValue() == 2)
                        .mapToInt(entry -> entry.getKey() * 2)
                        .findFirst();

                OptionalInt sumThreeFreqs = freqs.entrySet().stream()
                        .filter(entry -> entry.getValue() == 3)
                        .mapToInt(entry -> entry.getKey() * 3)
                        .findFirst();

                int sumTwoFreqsValue = sumTwoFreqs.orElse(0);
                int sumThreeFreqsValue = sumThreeFreqs.orElse(0);

                yield sumTwoFreqsValue == 0 || sumThreeFreqsValue == 0 ? 0 : sumTwoFreqsValue + sumThreeFreqsValue;
            }
            case FOUR_OF_A_KIND -> {
                Map<Integer, Long> freqs = scores.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                yield freqs.entrySet().stream()
                        .filter(entry -> entry.getValue() >= 4)
                        .mapToInt(entry -> entry.getKey() * 4)
                        .sum();
            }
            case LITTLE_STRAIGHT -> {
                List<Integer> littleStraight = Arrays.asList(1, 2, 3, 4, 5);
                if (new HashSet<>(scores).containsAll(littleStraight)) {
                    yield 30;
                } else {
                    yield 0;
                }
            }
            case BIG_STRAIGHT -> {
                List<Integer> littleStraight = Arrays.asList(2, 3, 4, 5, 6);
                if (new HashSet<>(scores).containsAll(littleStraight)) {
                    yield 30;
                } else {
                    yield 0;
                }
            }
            case CHOICE -> {
                 yield scores.stream().
                        mapToInt(Integer::intValue)
                        .sum();
            }
        };

        return score;
    }

}
