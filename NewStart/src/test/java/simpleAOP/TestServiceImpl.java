package simpleAOP;

public class TestServiceImpl implements TestService {
    @Override
    public void sayHello(String hello) {
        System.out.println("say hello!"+hello);
    }
}
