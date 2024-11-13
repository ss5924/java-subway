package subway;

import java.util.List;
import java.util.stream.Collectors;

public class PathPrinter {
    public static void printPath(List<Station> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("경로가 없습니다.");
            return;
        }

        String pathString = path.stream()
                .map(Station::getName)
                .collect(Collectors.joining(" -> "));

        System.out.println(pathString);
    }
}
