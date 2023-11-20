import java.util.*;

public class Scratch {
    public static void main(String[] args) {
        long[][] A = {{1, 54, 2394, 5342, 632, 2}, {23, 3, 3, 55, 2356, 8}, {343443, 534544, 3, 3, 2, 535}};
        long[][] result = digitTransformer(A);
        System.out.println(Arrays.deepToString(result));
        
    }

    public static long[][] digitTransformer(long[][] A){
        int rows = A.length;
        int coloumns = A[0].length;
        long[][] result = new long[rows][coloumns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < coloumns; j++){
                result[i][j] = count(A[i][j]);
            }
        } return result;
    }

    public static long count(long num){
        num = Math.abs(num);
        long count = 0;
        if (num < 10){
            return 1;
        }
        while (num >= 10){
            num = num / 10;
            count++;
        }
        return count;

    }

}