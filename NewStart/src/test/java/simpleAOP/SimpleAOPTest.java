package simpleAOP;

import org.junit.jupiter.api.Test;

public class SimpleAOPTest {
    @Test
    public void testAOP(){
        MethodInvocation methodInvocation = ()-> System.out.println("Hello");
        TestService testService = new TestServiceImpl();
        Advice advice = new BeforeAdvice(testService,methodInvocation);
        TestService service = (TestService) SimpleAOP.testService(testService,advice);
        service.sayHello("jasmine");
    }
}
