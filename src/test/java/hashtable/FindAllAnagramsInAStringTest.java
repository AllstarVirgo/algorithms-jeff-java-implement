package hashtable;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindAllAnagramsInAStringTest {

    @Test
    public void test(){
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        String s ="cbaebabacd";
        String p = "abc";
        findAllAnagramsInAString.findAnagrams(s,p);
    }

}