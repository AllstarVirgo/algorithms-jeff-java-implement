package backtrack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 01377809
 */
class NQueensTest {

    @Test
    void placeNQueens() {
        NQueens nQueens = new NQueens();
        int[] test = new int[11];
        nQueens.placeNQueens(test, 0);
        List<int[]> res = nQueens.resList;
        for (int[] temp:
        res){
           boolean tempRes = verify(temp);
           assertTrue(tempRes);
        }
    }

    boolean verify(int[] res) {
        boolean legal = true;
        int len = res.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(res[j]==res[i])
                    legal = false;
                if(j==i+1){
                    if(res[j]==res[i]-1||res[j]==res[i]+1)
                        legal = false;
                }
            }
        }
        return legal;
    }

    @Test
    void testChar(){
        char a ='a';
        char b = (char)(a+1);
        String s = "s";
        System.out.println(b);
    }

}