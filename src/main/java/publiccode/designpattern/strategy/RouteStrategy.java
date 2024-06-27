package publiccode.designpattern.strategy;

/**
 * Strategy Interface.
 *
 * 알고리즘을 캡슐화할 공통 인터페이스를 정의합니다.
 */
public interface RouteStrategy {

    Route buildRoute(String a, String b);
}
