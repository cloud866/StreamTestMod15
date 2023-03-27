import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
//        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
//        List<Double> doubles = new ArrayList<>();
//        for (String s : list2) {
//            doubles.add(Double.valueOf(s));
//        }
//        Set<Double> sortedDoubles = new TreeSet<>(Comparator.reverseOrder());
//        sortedDoubles.addAll(list);
//        sortedDoubles.addAll(doubles);
//        for (double d : sortedDoubles) {
//            System.out.println(d);
//        }

        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
        Stream.concat(
                        list.stream(),
                        list2.stream().map(Double::valueOf)
                )
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        IntStream stream = IntStream.rangeClosed(1, 100);
        int sum = stream
                .skip(50) // оставляем последние 50 элементов
                .filter(integer -> integer % 2 == 0 || integer % 5 == 0) // фильтруем
                .sum(); // суммируем
        System.out.println(sum); // 2275


        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("armadillo/shells.txt"));
    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println("Current parent is: " + currentPath);
        }
    }
}