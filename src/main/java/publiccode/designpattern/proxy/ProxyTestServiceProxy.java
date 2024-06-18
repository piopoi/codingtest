package publiccode.designpattern.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyTestServiceProxy implements ProxyTestService {

    private ProxyTestService proxyTestService;
    private Map<Long, String> cache;

    public ProxyTestServiceProxy() {
        proxyTestService = new RealProxyTestService();
        cache = new HashMap<>();
    }

    @Override
    public String findById(Long id) {
        if(cache.containsKey(id)) {
            System.out.println("Data for " + id + " is found in cache.");
            return cache.get(id);
        }
        String data = proxyTestService.findById(id);
        cache.put(id, data);
        return data;
    }
}

class Main {
    public static void main(String[] args) {
        ProxyTestService proxyTestService = new ProxyTestServiceProxy();
        System.out.println(proxyTestService.findById(1L));
        System.out.println(proxyTestService.findById(2L));
        System.out.println(proxyTestService.findById(1L));
    }
}
