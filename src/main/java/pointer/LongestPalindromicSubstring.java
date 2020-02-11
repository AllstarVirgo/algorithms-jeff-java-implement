package pointer;

import java.util.ArrayList;

public class LongestPalindromicSubstring {

    int lo = 0;

    int hi = 0;

    int len = 0;

    public String longestPalindrome(String s) {
        int len = s.length()        ;
        if(len<2)return s;

        for(int i = 0;i<len/2;i++){
            extendPalindromic(i,i+1,s);//even
            extendPalindromic(i,i,s);//odd
        }

        return s.substring(lo,hi+1);
    }

    void extendPalindromic(int i,int j,String s){
        while(i>=0&&j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else
                break;
        }

        int tempLen = j - i + 1;
        if(tempLen>len){
            lo = i;
            hi = j;
            len = tempLen;
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome(s);
    }
}
