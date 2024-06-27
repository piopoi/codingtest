package publiccode.designpattern.strategy;

/**
 * Context Class.
 * <p>
 * 전략 객체를 사용하는 클래스입니다.
 * 클라이언트는 Context를 통해 전략을 설정하고, Context는 설정된 전략을 통해 작업을 수행합니다.
 */
public class StrategyNavigator {

    private RouteStrategy routeStrategy;

    public StrategyNavigator() {
    }

    public StrategyNavigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public Route buildRoute(String start, String end) {
        if (routeStrategy == null) {
            throw new IllegalArgumentException("RouteStrategy not set.");
        }
        return routeStrategy.buildRoute(start, end);
    }
}
