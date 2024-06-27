package publiccode.designpattern.strategy;

public class NavigatorClient {
    public static void main(String[] args) {
        String start = "집";
        String end = "회사";

        //전략 패턴으로 리팩토링 하기 전.
        OriginNavigator originNavigator = new OriginNavigator();
        Route orgNaviRoute = originNavigator.buildRoadRoute(start, end);
        System.out.println(orgNaviRoute);

        //Strategy Pattern
        StrategyNavigator strategyNavigator = new StrategyNavigator();
        strategyNavigator.setRouteStrategy(new RoadStrategy());
        Route strategyRoute = strategyNavigator.buildRoute(start, end);
        System.out.println(strategyRoute);
    }
}
