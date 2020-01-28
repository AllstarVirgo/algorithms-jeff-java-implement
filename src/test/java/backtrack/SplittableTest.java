package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SplittableTest {
    Splittable splittable = new Splittable();

    @Test
    public void test(){
        String s = "dogs";
        List<String>list = new ArrayList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        splittable.wordBreak(s,list);
    }
}