package dp;

import backtrack.Dic;

/**
 * @author potato
 * @Date 2019/7/17 9:21
 */
public class SplitTable {
    Dic dic;

    /**
     * splitTable[j]  equals  A[j...n] can be split
     * @param s
     * @return
     */
    public boolean fastSplitTable(String s){
        int len = s.length();
        boolean[] splitTable = new boolean[len+1];
        splitTable[len] = true;
        for (int i = len-1; i >= 0; i--) {
            splitTable[i] = false;
            for (int j = i; j < len; j++) {
                if(dic.isWord(s.substring(i,j+1))&&splitTable[j+1])
                    splitTable[j] = true;
            }
        }
        return splitTable[1];
    }

    /**
     * splitTable[j]  equals  A[0...j-1] can be split
     * @param s
     * @return
     */
    public boolean forwardFastSplitTable(String s){
        int len = s.length();
        boolean[] splitTable = new boolean[len+1];
        splitTable[0] = true;
        for (int i = 0; i < len; i++) {
            splitTable[i+1] = false;
            for (int j = i; j < len; j++) {
                if(dic.isWord(s.substring(i,j+1))&&splitTable[i])
                    splitTable[j+1] = true;
            }
        }
        return splitTable[len];
    }
}
