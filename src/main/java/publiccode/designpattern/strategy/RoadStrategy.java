package publiccode.designpattern.strategy;

/**
 * Concrete Strategy Class.
 * <p>
 * Strategy 인터페이스를 구현한 다양한 알고리즘을 정의합니다.
 */
public class RoadStrategy implements RouteStrategy {

    @Override
    public Route buildRoute(String start, String end) {
        return new Route("RoadRoute: " + start + " to " + end);
    }
}
