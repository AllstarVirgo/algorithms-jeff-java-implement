package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0)return new ArrayList<>();
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer>list = new ArrayList<>();
        travel(0,0,m,n,visited,list,matrix);
        return list;
    }

    void travel(int x,int y,int m,int n,boolean[][] visited,List<Integer>list,int[][] matrix){
        if(list.size()==m*n)return;
        while(y<n&&!visited[x][y]){
            list.add(matrix[x][y]);
            visited[x][y] = true;
            y = y+1;
        }

        x = x+1;
        y--;
        while(x<m && !visited[x][y]){
            list.add(matrix[x][y]);
            visited[x][y] = true;
            x = x+1;
        }

        y = y-1;
        x--;
        while(y>=0&&!visited[x][y]){
            list.add(matrix[x][y]);
            visited[x][y] = true;
            y = y-1;
        }

        x = x-1;
        y++;
        while(x>=0&&!visited[x][y]){
            list.add(matrix[x][y]);
            visited[x][y] = true;
            x = x-1;
        }
        travel(x+1,y+1,m,n,visited,list,matrix);
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        sm.spiralOrder(test);
    }
}
