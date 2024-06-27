package publiccode.designpattern.strategy;

/**
 * 전략 패턴을 적용하기 전 Context Class.
 * <p>
 * 3가지 길 찾기 기능이 하나의 클래스에 모여 있다.
 */
public class OriginNavigator {

    public OriginNavigator() {
    }

    public Route buildRoadRoute(String start, String end) {
        return new Route("RoadRoute: " + start + " to " + end);
    }

    public Route buildWalkingRoute(String start, String end) {
        return new Route("WalkingRoute: " + start + " to " + end);
    }

    public Route buildPublicTransportRoute(String start, String end) {
        return new Route("PublicTransportRoute: " + start + " to " + end);
    }
}
