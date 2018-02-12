import java.io.*;
import java.lang.*;
import java.util.*;

public class countIsland{
    public static void main(String[] args){
        int arr[][] = new int[5][5];
        Scanner s = new Scanner(System.in);
        int i,j, size = 0;
        countIsland c = new countIsland();
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                arr[i][j] = s.nextInt(); 
            }
        }
        for(i = 0; i < 5; i++){
            for(j = 0; j < 5; j++){
                if(arr[i][j] == 1){
                    c.changeMe(arr, i, j, 5);
                    size++;
                }
            }
        }
        System.out.println(size);
    }
    public void changeMe(int arr[][], int i, int j, int size){
        arr[i][j] = 0;
        if(i+1 < size && arr[i+1][j] == 1)
            changeMe(arr, i+1, j, size);
        if(j+1 < size && arr[i][j+1] == 1)
            changeMe(arr, i, j+1, size);
        if(i+1 < size && j+1 < size && arr[i+1][j+1] == 1)
            changeMe(arr, i+1, j+1, size);
        if(i+1 < size && j-1 >= 0 && arr[i+1][j-1] == 1)
            changeMe(arr, i+1, j-1, size);
        if(i-1 >= 0 && arr[i-1][j] == 1)
            changeMe(arr, i-1, j, size);
        if(i-1 >= 0 && j-1 >= 0 && arr[i-1][j-1] == 1)
            changeMe(arr, i-1, j-1, size);
        if(j-1 >= 0 && arr[i][j-1] == 1)
            changeMe(arr, i, j-1, size);
        if(i-1 >= 0 && j+1 < size && arr[i-1][j+1] == 1)
            changeMe(arr, i-1, j+1, size); 
    }
}
