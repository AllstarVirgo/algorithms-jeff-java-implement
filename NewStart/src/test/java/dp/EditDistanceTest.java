package dp;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @org.junit.jupiter.api.Test
    void getEditDistance() {
        EditDistance editDistance = new EditDistance();
        String source = "ALGORITHM";
        String des = "ALTRUISTIC";
        assertEquals(6,editDistance.getEditDistance(source,des));
    }
}