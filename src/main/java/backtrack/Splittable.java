package backtrack;

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
}

