package backtrack;

public class LIS {
    public int lis1(int prev,int index,int[] array){
        if(index == array.length)
            return 0;
        if(array[index]<array[prev]){
            return lis1(prev,index+1,array);
        }else {
            int skip = lis1(prev,index+1,array);
            int take = lis1(index,index+1,array)+1;
            return Math.max(skip,take);
        }
    }

    /**
     * 该算法求得的是最长字串的增长。{1,2} 用list2求得的结果为1
     * @param index
     * @param array
     * @return
     */
    public int lis2(int index,int[] array){
        int longest = 0;
        for (int i = index+1; i < array.length ; i++) {
            if(array[i]>array[index]){
                longest = Math.max(longest,1+lis2(i,array));
            }
        }
        return longest;
    }
}
