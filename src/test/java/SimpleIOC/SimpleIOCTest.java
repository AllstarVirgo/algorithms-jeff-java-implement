package SimpleIOC;

import org.junit.jupiter.api.Test;

public class SimpleIOCTest {
    @Test
    public void testSimpleIOC(){
        XmlReader xmlReader = new XmlReader("context.xml");
        TestBean testBean = (TestBean) xmlReader.getBean("test");
        System.out.println(testBean);
    }
}
