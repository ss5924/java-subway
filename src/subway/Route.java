package subway;

public class Route {
    private final Station start;
    private final Station end;
    private final int distance;
    private final int time;

    public Route(Station start, Station end, int distance, int time) {
        validate(start, end, distance, time);
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
    }

    private void validate(Station start, Station end, int distance, int time) {
        if (distance <= 0) {
            throw new IllegalArgumentException("[ERROR] 거리는 양수만 가능합니다.");
        }

        if (time <= 0) {
            throw new IllegalArgumentException("[ERROR] 소요 시간은 양수만 가능합니다.");
        }
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
