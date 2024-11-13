package subway;

import java.util.Objects;

public class Station {
    private final String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 20) {
            throw new IllegalArgumentException("[ERROR] 이름은 두글자 이상 20자 이하 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return name.equals(station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}