import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {

    <T> List<T> flatten(List<T> list) {
        return (List<T>) list.stream()
                .flatMap(element -> {
                    if (element == null) {
                        return Stream.empty();
                    } else if (element instanceof List<?>) {
                        return flatten((List<?>) element).stream();
                    } else {
                        return Stream.of(element);
                    }
                })
                .collect(Collectors.toList());
    }

}