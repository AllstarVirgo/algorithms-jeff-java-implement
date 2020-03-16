package pointtooffer;

import java.util.ArrayList;

public class MinKNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int n = input.length;
        for(int i = n/2-1;i>=0;i--){
            heapify(input,i,n-1);
        }

        ArrayList<Integer>res = new ArrayList<>();
        for(int i = n-1,j = 0;i>=0&&j<k;i--){
            res.add(input[0]);
            swap(input,0,i);
            heapify(input,0,i);
            j++;
        }
        return res;
    }

    void heapify(int[] input,int start,int end){
        int left = (start<<1) + 1;
        int right = left + 1;
        int min = left;
        if(left > end)return;
        if(right <= end && input[right]<input[left])
            min = right;
        if(input[min]<input[start]){
            swap(input,min,start);
            heapify(input,min,end);
        }
    }

    void swap(int[] input,int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        MinKNumber mk = new MinKNumber();
        int[] demo = {4,5,1,6,2,7,3,8};
        mk.GetLeastNumbers_Solution(demo,4);
    }
}
