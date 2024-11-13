package subway;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private final List<Route> routes;

    public Line() {
        this.routes = new ArrayList<>();
    }

    public Line(String name, List<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public void addRoutes(Route route) {
        routes.add(route);
    }

    public String getName() {
        return name;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
