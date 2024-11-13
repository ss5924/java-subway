package subway;

public class RouteNode {
    private final Station station;
    private final int cost;

    public RouteNode(Station station, int cost) {
        this.station = station;
        this.cost = cost;
    }

    public Station getStation() {
        return station;
    }

    public int getCost() {
        return cost;
    }
}