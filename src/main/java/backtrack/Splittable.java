package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Splittable {
    Dic dic;

    public boolean splittable(String s,int subIndex){
        for (int i = subIndex+1; i <= s.length(); i++) {
            if(dic.isWord(s.substring(subIndex,i)))
                 if(splittable(s,i))
                     return true; 
        }
        return false;
    }

    public boolean isSpilttable(String s){
        return splittable(s,0);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        outer:
        for(int i = 1;i<=len;i++){
            inner:
            for(int j=0;j<wordDict.size();j++){
                String temp = wordDict.get(j);
                int tempLen = temp.length();
                if(tempLen<=i&&temp.equals(s.substring(i-tempLen,i))){
                    dp[i] = dp[i-tempLen];
                }
                if(dp[i])
                    continue outer;
            }
        }
        return dp[len];
    }
}

