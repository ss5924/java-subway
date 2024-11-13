package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwaySystem {
    private List<Line> lines;

    public SubwaySystem() {
        initialize();
    }

    public void initialize() {
        Station gyodae = new Station("교대");
        Station gangnam = new Station("강남");
        Station yeoksam = new Station("역삼");
        Station nambuterminal = new Station("남부터미널");
        Station yangjae = new Station("양재");
        Station yangjaeCitizenForest = new Station("양재시민의숲");
        Station maebung = new Station("매봉");

        Line line2 = new Line("2호선", Arrays.asList(
                new Route(gangnam, gyodae, 2, 3),
                new Route(gyodae, gangnam, 2, 3),
                new Route(gangnam, yeoksam, 2, 3),
                new Route(yeoksam, gangnam, 2, 3)
        ));

        Line line3 = new Line("3호선", Arrays.asList(
                new Route(nambuterminal, gyodae, 3, 2),
                new Route(gyodae, nambuterminal, 3, 2),
                new Route(nambuterminal, yangjae, 6, 5),
                new Route(yangjae, nambuterminal, 6, 5),
                new Route(yangjae, maebung, 1, 1),
                new Route(maebung, yangjae, 1, 1)
        ));

        Line newbundang = new Line("신분당선", Arrays.asList(
                new Route(gangnam, yangjae, 2, 8),
                new Route(yangjae, gangnam, 2, 8),
                new Route(yangjae, yangjaeCitizenForest, 10, 3),
                new Route(yangjaeCitizenForest, yangjae, 10, 3)
        ));

        lines = new ArrayList<>();
        lines.addAll(Arrays.asList(line2, line3, newbundang));
    }

    public List<Line> getLines() {
        return lines;
    }

}
