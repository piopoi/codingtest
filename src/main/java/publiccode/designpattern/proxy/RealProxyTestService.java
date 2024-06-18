package publiccode.designpattern.proxy;

public class RealProxyTestService implements ProxyTestService {

    @Override
    public String findById(Long id) {
        System.out.println("Data for " + id + " is found in database.");
        return "Data for " + id;
    }
}
