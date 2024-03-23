import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

    List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");

    List<Plant> window1 = new ArrayList<>();
    List<Plant> window2 = new ArrayList<>();

    KindergartenGarden(String garden) {

        String[] gardens = garden.split("\n");

        for (char c : gardens[0].toCharArray()) {
            window1.add(Plant.getPlant(c));
        }

        for (char c : gardens[1].toCharArray()) {
            window2.add(Plant.getPlant(c));
        }

    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();

        int index = names.indexOf(student);

        plants.add(window1.get(index * 2));
        plants.add(window1.get(index * 2 + 1));

        plants.add(window2.get(index * 2));
        plants.add(window2.get(index * 2 + 1));

        return plants;
    }

}
