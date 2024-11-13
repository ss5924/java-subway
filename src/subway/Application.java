package subway;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();
        SubwaySystem subwaySystem = new SubwaySystem();

        List<Station> result1 = pathFinder.findPathByShortestDistance(new Station("강남"), new Station("남부터미널"), subwaySystem.getLines());
        List<Station> result2 = pathFinder.findPathByShortestTime(new Station("양재"), new Station("강남"), subwaySystem.getLines());

        PathPrinter.printPath(result1);
        PathPrinter.printPath(result2);
    }

}
