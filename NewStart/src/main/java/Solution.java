import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        sortDrecaseHeightAndIncreaseK(people,0,people.length-1);
        int[][] res = new int[people.length][2];
        for(int i =0;i<res.length;i++){
            int index = people[i][1];
            for(int j = i;j>index;j--){
                res[j] = res[j-1];
            }
            res[index] = people[i];
        }
        return res;
    }

    private void sortDrecaseHeightAndIncreaseK(int[][] people,int lo,int hi){
        if((hi - lo)>0){
            int partIndex = part(people,lo,hi);
            sortDrecaseHeightAndIncreaseK(people,lo,partIndex-1);
            sortDrecaseHeightAndIncreaseK(people,partIndex+1,hi);
        }
    }

    private void switchArray(int[][] people,int i,int j){
        int[] temp = people[i];
        people[i] = people[j];
        people[j] = temp;
    }

    private int part(int[][] people,int lo,int hi){
        int pivot = people[lo][0];
        int secondPivot = people[lo][1];
        switchArray(people,lo,hi);
        int cur = lo;
        for(int i=cur;i<hi;i++){
            if( people[i][0] > pivot){
                switchArray(people,cur,i);
                cur++;
            }else if(people[i][0] == pivot){
                if(people[i][1]<secondPivot){
                    switchArray(people,cur,i);
                    cur++;
                }
            }
        }
        switchArray(people,hi,cur);
        return cur;
    }

    public static void main(String[] args) {
        System.out.println("请输入[h,k]的数量");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("请依次输入每一对的h  k");
        int[][] testArray = new int[len][2];
        for (int i = 0; i < len; i++) {
            int h = scanner.nextInt();
            int k = scanner.nextInt();
            testArray[i][0] = h;
            testArray[i][1] = k;
            System.out.println("当前已输入"+h+" "+k);
        }
        Solution solution = new Solution();
        int[][] res = solution.reconstructQueue(testArray);
        for (int i = 0; i < len; i++) {
            System.out.print(Arrays.toString(res[i]));
            System.out.print("\t");
        }
        ArrayList<Integer>list = new ArrayList<>();
    }
}