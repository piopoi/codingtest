package publiccode.designpattern.strategy;

public class Route {

    private String value;

    public Route(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
