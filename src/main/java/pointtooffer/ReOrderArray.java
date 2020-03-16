package pointtooffer;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int oddP = 0,evenP = 0,n = array.length;
        while(oddP<n){
            while(oddP<n && (array[oddP]&1)==1){
                oddP++;
            }
            evenP = oddP + 1;
            while(evenP<n && (array[evenP]&1)==0){
                evenP++;
            }
            if(evenP>=n)break;
            int temp = array[evenP];
            for(int i = evenP;i>oddP;i--){
                array[i] = array[i-1];
            }
            array[oddP] = temp;
        }
    }
}
