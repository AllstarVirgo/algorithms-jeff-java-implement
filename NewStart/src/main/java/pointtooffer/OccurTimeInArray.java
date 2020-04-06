package pointtooffer;

public class OccurTimeInArray {
    public int GetNumberOfK(int [] array , int k) {
        //利用浮点数计算了最后一次出现的位置、以及第一次出现的位置
        return binarySearch(array,k+0.5) - binarySearch(array,k-0.5);
    }

    int binarySearch(int[] array,double target){
        int left = 0,right = array.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(array[mid]<target)
                left = mid + 1;
            else if(array[mid]>target)
                right = mid-1;
        }
        return left;
    }
}
