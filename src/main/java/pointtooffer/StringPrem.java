package pointtooffer;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPrem {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String>res = new ArrayList<>();
        if(str ==null || str.trim().length()==0)return res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<Character>list = new ArrayList<>();

        backtrace(chars,0,res,list);
        return res;
    }

    void backtrace(char[] chars,int index,ArrayList<String>list,ArrayList<Character> lists){
        if(lists.size() == chars.length){
            String s = "";
            for(int i = 0;i<lists.size();i++){
                s+=lists.get(i);
            }
            list.add(s);
            return;
        }

        for(int i = index;i<chars.length;i++){
            if(i>0&&chars[i] == chars[i-1])continue;
            lists.add(chars[i]);
            backtrace(chars,index+1,list,lists);
            lists.remove(lists.size()-1);
        }

    }
}
