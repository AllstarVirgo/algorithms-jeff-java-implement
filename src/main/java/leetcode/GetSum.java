package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetSum {
    static String getSum(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int cur1 = 0,cur2 = 0,carry = 0;
        List<String> list = new ArrayList<>();
        while(cur1<l1 || cur2<l2){
            int c1,c2;
            if(cur1<l1)
                c1 = s1.charAt(cur1)-'0';
            else
                c1 = 0;
            if(cur2<l2)
                c2 = s2.charAt(cur2)-'0';
            else
                c2 = 0;
            int tempSum = c1+c2 + carry;
            if(tempSum>=10){
                int tempSum1 = tempSum;
                tempSum %= 10;
                carry = tempSum1/10;
            }
            list.add(Integer.toString(tempSum));
            cur1++;
            cur2++;
        }
        String res ="";
        for(int i =list.size()-1;i>=0;i--){
            res +=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        getSum("1","9999");
    }
}
